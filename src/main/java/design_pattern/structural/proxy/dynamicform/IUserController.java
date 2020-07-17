package design_pattern.structural.proxy.dynamicform;

public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}
