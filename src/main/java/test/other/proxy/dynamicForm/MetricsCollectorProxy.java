package test.other.proxy.dynamicForm;


import java.lang.reflect.Proxy;

/**
 * @author chenyuqun
 * @date 2020/11/10 10:16 上午
 */
public class MetricsCollectorProxy {

    public Object createProxy(Object object) {
        Class[] interfaces = object.getClass().getInterfaces();
        MetricsDynamicHandler dynamicProxyHandler = new MetricsDynamicHandler(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), interfaces, dynamicProxyHandler);
    }
}
