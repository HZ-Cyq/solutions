package mobinusi;

import mobinusi.handler.LogicHandlerAnnotation;
import mobinusi.handler.LogicMethodAnnotation;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ILogicManager {
    private static ILogicManager instance = new ILogicManager();

    private ConcurrentHashMap<Integer, Method> logicMethods = new ConcurrentHashMap<>();

    private ILogicManager() {
    }

    public void init(String handlerPackageName) {
        Reflections reflections = new Reflections(handlerPackageName);
        Set<Class<?>> models = reflections.getTypesAnnotatedWith(LogicHandlerAnnotation.class);
        for (Class<?> model : models) {
            Method[] declaredMethods = model.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                LogicMethodAnnotation annotation = declaredMethod.getAnnotation(LogicMethodAnnotation.class);
                logicMethods.put(annotation.opCode(), declaredMethod);
            }
        }
    }

    public static ILogicManager getInstance() {
        return instance;
    }

    public Method getMethodByOpCode(int opCode) {
        return logicMethods.get(opCode);
    }
}
