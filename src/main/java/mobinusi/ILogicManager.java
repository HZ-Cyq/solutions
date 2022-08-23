package mobinusi;

import cn.hutool.core.util.ClassUtil;
import com.alibaba.fastjson.JSONObject;
import mobinusi.handler.ILogicHandler;
import mobinusi.handler.LogicHandlerAnnotation;
import mobinusi.handler.LogicMethodAnnotation;

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
    private final ConcurrentHashMap<Integer, ILogicHandler> logicHandlersMap = new ConcurrentHashMap<>();

    /**
     * key是method的opCode
     * value是对应的method
     */
    private final ConcurrentHashMap<Integer, Method> logicMethodsMap = new ConcurrentHashMap<>();

    private ILogicManager() {
    }

    public void init(String handlerPackageName) {
        System.out.println("ILogicManager begin init");
        if (!logicHandlersMap.isEmpty() || !logicMethodsMap.isEmpty()) {
            throw new RuntimeException("初始化ILogicManager错误，已经初始化过了");
        }
        Set<Class<?>> classes = ClassUtil.scanPackage(handlerPackageName);
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
            if (!handlerClass.isAnnotationPresent(LogicHandlerAnnotation.class) || handlerClass.isAssignableFrom(ILogicHandler.class)) {
                continue;
            }
            ILogicHandler handler = null;
            try {
                handler = (ILogicHandler) handlerClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException("初始化ILogicManager错误，创建handler实例错误");
            }
            logicHandlersMap.put(handlerClass.getAnnotation(LogicHandlerAnnotation.class).handlerCode(), handler);
            Method[] declaredMethods = handlerClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                LogicMethodAnnotation annotation = declaredMethod.getAnnotation(LogicMethodAnnotation.class);
                if (annotation == null) {
                    continue;
                }
                logicMethodsMap.put(annotation.methodCode(), declaredMethod);
            }
        }
        System.out.println("ILogicManager init over");
    }

    public static ILogicManager getInstance() {
        return instance;
    }

    public Object invoke(int methodCode, Player player, JSONObject jsonObject) {
        int handlerCode = methodCode / 100 * 100;
        ILogicHandler handler = logicHandlersMap.get(handlerCode);
        Method method = logicMethodsMap.get(methodCode);
        Object re = null;
        try {
            re = method.invoke(handler, player, jsonObject);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return re;
    }
}
