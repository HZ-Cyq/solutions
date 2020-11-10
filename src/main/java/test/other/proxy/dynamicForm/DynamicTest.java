package test.other.proxy.dynamicForm;

import org.junit.Test;

/**
 * @author chenyuqun
 * @date 2020/11/10 10:37 上午
 */
public class DynamicTest {

    @Test
    public void testDynamic() {
        MetricsCollectorProxy metricsCollectorProxy = new MetricsCollectorProxy();
        IUserController proxiedUserController = (IUserController) metricsCollectorProxy.createProxy(new UserController());
        proxiedUserController.register("333", "444");
        proxiedUserController.login("111", "222");
    }

}
