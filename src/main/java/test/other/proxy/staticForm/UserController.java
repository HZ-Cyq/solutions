package test.other.proxy.staticForm;

/**
 * @author chenyuqun
 */
public class UserController implements IUserController {
    @Override
    public void register(String telephone, String password) {
        System.out.println("UserController: " + telephone + " register");
    }

    @Override
    public void login(String telephone, String password) {
        System.out.println("UserController: " + telephone + " login");
    }
}
