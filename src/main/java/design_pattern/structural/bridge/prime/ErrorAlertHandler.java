package design_pattern.structural.bridge.prime;

import design_pattern.structural.bridge.AlertRule;
import design_pattern.structural.bridge.NotificationEmergencyLevel;

/**
 * @author chenyuqun
 */
public class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if(apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            System.out.println("ErrorAlertHandler notify");
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
