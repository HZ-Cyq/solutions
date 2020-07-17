package design_pattern.structural.bridge.bridge;

import design_pattern.structural.bridge.bridge.handler.AlertHandler;
import design_pattern.structural.bridge.bridge.handler.ErrorAlertHandler;
import design_pattern.structural.bridge.bridge.notification.UrgencyNotification;
import design_pattern.structural.bridge.bridge.sender.EmailMsgSender;
import design_pattern.structural.bridge.AlertRule;
import design_pattern.structural.bridge.bridge.handler.TpsAlertHandler;
import design_pattern.structural.bridge.bridge.notification.Notification;
import design_pattern.structural.bridge.bridge.notification.SevereNotification;
import design_pattern.structural.bridge.bridge.sender.TelephoneMsgSender;

/**
 * @author chenyuqun
 */
public class ApplicationContext {
    private AlertRule alertRule;
    private Alert alert;

    private void initializeBeans() {
        alertRule = new AlertRule();
        alert = new Alert();
        // 在这里设置handle的报警级别，设置报警级别的信息发送类型。
        Notification severeNotification = new SevereNotification(new TelephoneMsgSender());
        Notification urgencyNotification = new UrgencyNotification(new EmailMsgSender());

        AlertHandler tpsAlertHandler = new TpsAlertHandler(alertRule, severeNotification);
        AlertHandler errorAlertHandler = new ErrorAlertHandler(alertRule, urgencyNotification);

        alert.addAlertHandle(tpsAlertHandler);
        alert.addAlertHandle(errorAlertHandler);

    }

    private static ApplicationContext instance = new ApplicationContext();

    private ApplicationContext() {
        initializeBeans();
    }

    public static ApplicationContext getInstance() {
        return instance;
    }

    public Alert getAlert() {
        return alert;
    }
}
