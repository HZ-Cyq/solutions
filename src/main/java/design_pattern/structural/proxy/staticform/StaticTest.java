package design_pattern.structural.proxy.staticform;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class StaticTest {
    @Test
     public void testStatic2() {
        IUserController userController = new UserControllerProxy(new UserController());
        userController.login("hello","world");
    }
}
