package design_pattern.structural.proxy.staticform.static2;


import design_pattern.structural.proxy.UserVo;

/**
 * @author playcrab_chenyuqun
 */
public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}
