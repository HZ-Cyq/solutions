package test.other.proxy.dynamicForm;

/**
 * @author chenyuqun
 * @date 2020/11/10 10:46 上午
 */
public class UserController implements IUserController{
    @Override
    public UserVo register(String telephone, String password) {
        System.out.println("register: " + telephone + " " + password );
        return null;
    }

    @Override
    public UserVo login(String telephone, String password) {
        System.out.println("login: " + telephone + " " + password);
        return null;
    }
}
