package design_pattern.structural.proxy.dynamicform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chenyuqun
 */
public class MetricsCollectorHandler implements InvocationHandler {
    private MetricsCollector collector = new MetricsCollector();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTimestamp = System.currentTimeMillis();

        Object re = method.invoke(proxy, args);

        long endTimestamp = System.currentTimeMillis();
        String apiName = proxy.getClass() + "." + method.getName();
        RequestInfo requestInfo = new RequestInfo(apiName, endTimestamp - startTimestamp, startTimestamp);
        collector.recordRequest(requestInfo);
        return re;
    }
}
