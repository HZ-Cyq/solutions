package mobinusi.handler;

import cn.hutool.core.util.ClassUtil;
import com.alibaba.fastjson.JSONObject;
import mobinusi.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ILogicManager {

    private static ILogicManager instance = new ILogicManager();

    /**
     * key是handler的modeCode
     * value是具体的handler
     */
    private final ConcurrentHashMap<Integer, ConsumeMsgHandler> logicHandlersMap = new ConcurrentHashMap<>();

    /**
     * key是method的opCode
     * value是对应的method
     */
    private ConcurrentHashMap<Integer, Method> logicMethodsMap = new ConcurrentHashMap<>();

    private ILogicManager() {
    }

    public void init() {
        System.out.println("ILogicManager begin init");
        if (!logicHandlersMap.isEmpty() || !logicMethodsMap.isEmpty()) {
            throw new RuntimeException("初始化ILogicManager错误，已经初始化过了");
        }
        Set<Class<?>> classes = ClassUtil.scanPackage(getClass().getPackage().getName());
        // 第二种方案，用guava
//        try {
//            ClassPath classPath = ClassPath.from(ClassLoader.getSystemClassLoader());
//            ImmutableSet<ClassPath.ClassInfo> topLevelClasses = classPath.getTopLevelClasses("mobinusi.handler");
//            for (ClassPath.ClassInfo topLevelClass : topLevelClasses) {
//                System.out.println(topLevelClass.getName());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        for (Class<?> handlerClass : classes) {
            // 没有LogicHandlerAnnotation注解或者没实现ILogicHandler接口，不算
            if (!ConsumeMsgHandler.class.isAssignableFrom(handlerClass)) {
                continue;
            }
            HandlerAnnotation handlerAnnotation = handlerClass.getAnnotation(HandlerAnnotation.class);
            if (handlerAnnotation == null) {
                continue;
            }
            ConsumeMsgHandler handler;
            try {
                handler = (ConsumeMsgHandler) handlerClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException("初始化ILogicManager错误，创建handler实例错误");
            }
            logicHandlersMap.put(handlerAnnotation.handlerCode(), handler);
            Method[] declaredMethods = handlerClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                HandlerMethodAnnotation annotation = declaredMethod.getAnnotation(HandlerMethodAnnotation.class);
                if (annotation == null) {
                    continue;
                }
                if (annotation.methodCode() / 100 * 100 != handlerAnnotation.handlerCode()) {
                    throw new RuntimeException("初始化ILogicManager错误，方法的code和handler的code不一致" +
                            annotation.methodCode() + ", " + handlerAnnotation.handlerCode());
                }
                Method previous_method = logicMethodsMap.put(annotation.methodCode(), declaredMethod);
                if (previous_method != null) {
                    throw new RuntimeException("初始化ILogicManager错误，有重复的methodCode " + annotation.methodCode());
                }
            }
        }
        System.out.println("ILogicManager init over");
    }

    public static ILogicManager getInstance() {
        return instance;
    }

    public Object invoke(int methodCode, Player player, JSONObject jsonObject) {
        int handlerCode = methodCode / 100 * 100;
        ConsumeMsgHandler handler = logicHandlersMap.get(handlerCode);
        Method method = logicMethodsMap.get(methodCode);
        Object re = null;
        try {
            re = method.invoke(handler, player, jsonObject);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            System.err.println("无法消耗：" + method + ", " + JSONObject.toJSONString(jsonObject));
        }
        return re;
    }
}
