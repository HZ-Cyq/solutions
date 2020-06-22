package designpattern.structural.proxy.staticform.static2;

import designpattern.structural.proxy.UserVo;

/**
 * @author playcrab_chenyuqun
 */
public class UserController implements IUserController{
    private MetricsCollector metricsCollector = new MetricsCollector();

    @Override
    public UserVo login(String telephone, String password) {
        // 省略login的逻辑
        // 返回UserVo数据
        return null;
    }

    @Override
   public UserVo register(String telephone, String password) {
        // 省略register的逻辑
        // 返回UserVo数据
        return null;
    }

}
