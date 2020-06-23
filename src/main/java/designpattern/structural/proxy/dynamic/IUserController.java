package designpattern.structural.proxy.dynamic;

public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}