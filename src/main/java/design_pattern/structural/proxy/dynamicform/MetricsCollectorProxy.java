package design_pattern.structural.proxy.dynamicform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理模式的动态实现，哪个handler需要用MetricsCollector统计方法的调用时间，可以直接用createProxy将该handle注册进去。
 *
 * @author playcrab_chenyuqun
 */
public class MetricsCollectorProxy {

    public Object createProxy(Object proxiedObject) {
        Class[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }
}
