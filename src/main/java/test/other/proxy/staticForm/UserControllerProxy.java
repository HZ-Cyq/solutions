package test.other.proxy.staticForm;

/**
 * @author chenyuqun
 */
public class UserControllerProxy implements IUserController {
    UserController userController;

    MetricsCollector metricsCollector;

    public UserControllerProxy(UserController userController, MetricsCollector metricsCollector) {
        this.userController = userController;
        this.metricsCollector = metricsCollector;
    }

    @Override
    public void register(String telephone, String password) {
        long startTimeStamp = System.currentTimeMillis();

        this.userController.register(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        this.metricsCollector.recordInfo(new RequestInfo("register", endTimeStamp - startTimeStamp, startTimeStamp));
    }

    @Override
    public void login(String telephone, String password) {
        long startTimeStamp = System.currentTimeMillis();

        this.userController.login(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        this.metricsCollector.recordInfo(new RequestInfo("login", endTimeStamp - startTimeStamp, startTimeStamp));
    }
}
