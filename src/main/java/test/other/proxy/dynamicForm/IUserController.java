package test.other.proxy.dynamicForm;

public interface IUserController {
    UserVo register(String telephone, String password);

    UserVo login(String telephone, String password);
}
