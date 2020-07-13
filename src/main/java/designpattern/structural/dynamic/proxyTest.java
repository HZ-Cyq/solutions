package designpattern.structural.dynamic;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class proxyTest {
    @Test
    public void testProxy() {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
        System.out.println("hello");
        userController.login("hello","world");
        userController.register("hello","world");
    }
}
