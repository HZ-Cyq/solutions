package test.other.proxy.staticForm;

import org.junit.Test;

/**
 * @author chenyuqun
 */
public class StaticTest {

    @Test
    public void test() {
        IUserController userController = new UserControllerProxy(new UserController(), new MetricsCollector());
        userController.login("111","111");
        userController.register("222", "222");
    }
}
