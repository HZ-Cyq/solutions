package test.other.proxy.dynamicForm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chenyuqun
 * @date 2020/11/10 10:21 上午
 */
public class MetricsDynamicHandler implements InvocationHandler {

    private Object proxiedObject;

    private MetricsCollector collector = new MetricsCollector();

    public MetricsDynamicHandler(Object proxiedObject) {
        this.proxiedObject = proxiedObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTimeStamp = System.currentTimeMillis();
        // TODO: 这里面传入的为什么是handler里的proxiedObject? 【因为下面方法的执行需要的是UserController, 在测试用例中new出来的那个实例。 那么方法参数里的proxy是什么？
        Object re = method.invoke(proxiedObject, args);
        long finishTimeStamp = System.currentTimeMillis();
        collector.addRequestInfo(new RequestInfo(method.getName(), startTimeStamp, finishTimeStamp - startTimeStamp));
        return re;
    }
}
