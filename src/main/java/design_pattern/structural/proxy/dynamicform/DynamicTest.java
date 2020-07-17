package design_pattern.structural.proxy.dynamicform;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class DynamicTest {
    @Test
    public void testProxy() {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
        System.out.println("hello");
        userController.login("hello","world");
        userController.register("hello","world");
    }
}
