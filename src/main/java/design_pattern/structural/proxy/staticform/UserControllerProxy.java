package design_pattern.structural.proxy.staticform;

import design_pattern.structural.proxy.dynamicform.RequestInfo;
import design_pattern.structural.proxy.dynamicform.UserVo;

/**
 * 代理模式的静态实现，不会改变原始类的接口。主要目的是控制访问。而非加强功能。
 * 这个例子就是用MetricsCollector统计登录和注册的耗时。
 *
 * @author playcrab_chenyuqun
 */
public class UserControllerProxy implements IUserController {
    private UserController userController;
    private MetricsCollector metricsCollector;

    public UserControllerProxy(UserController userController) {
        this.userController = userController;
        this.metricsCollector = new MetricsCollector();
    }

    @Override
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        // 委托
        UserVo userVo = userController.login(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        // 委托
        UserVo userVo = userController.login(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }
}
