package design_pattern.structural.bridge.prime;

import design_pattern.structural.bridge.AlertRule;

/**
 * @author chenyuqun
 */
public class ApplicationContext {
    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;

    public void initializeBeans() {
        alertRule = new AlertRule();
        notification = new Notification();
        alert = new Alert();

        AlertHandler tpsAlertHandler = new TpsAlertHandler(alertRule, notification);
        AlertHandler errorAlertHandler = new ErrorAlertHandler(alertRule, notification);
        alert.addAlertHandle(tpsAlertHandler);
        alert.addAlertHandle(errorAlertHandler);
    }

    public Alert getAlert() {
        return alert;
    }
    private static final ApplicationContext instance = new ApplicationContext();

    private ApplicationContext() {
        initializeBeans();
    }
    public static ApplicationContext getInstance() {
        return instance;
    }
}
