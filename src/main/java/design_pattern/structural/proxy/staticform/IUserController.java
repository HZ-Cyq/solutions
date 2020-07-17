package design_pattern.structural.proxy.staticform;


import design_pattern.structural.proxy.dynamicform.UserVo;

/**
 * @author playcrab_chenyuqun
 */
public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}
