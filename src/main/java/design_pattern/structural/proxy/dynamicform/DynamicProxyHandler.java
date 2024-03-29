package design_pattern.structural.proxy.dynamicform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author playcrab_chenyuqun
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object proxiedObject;

    // 有一个proxyHandler，就有一个metricsCollector, 不需要从外界传入。
    private MetricsCollector metricsCollector = new MetricsCollector();

    public DynamicProxyHandler(Object proxiedObject) {
        this.proxiedObject = proxiedObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTimestamp = System.currentTimeMillis();
        Object result = method.invoke(proxiedObject, args);
        long endTimestamp = System.currentTimeMillis();
        long responseTime = endTimestamp - startTimestamp;
        String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
        RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return result;
    }
}
