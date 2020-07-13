package design_pattern.structural.proxy.staticform.static2;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class Static2Test {
    @Test
     public void testStatic2() {
        IUserController userController = new UserControllerProxy(new UserController());
        userController.login("hello","world");
    }
}
