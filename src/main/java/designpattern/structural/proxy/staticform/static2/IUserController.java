package designpattern.structural.proxy.staticform.static2;

import designpattern.structural.proxy.UserVo;

/**
 * @author playcrab_chenyuqun
 */
public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}
