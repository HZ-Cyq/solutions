package design_pattern.structural.bridge.bridge.handler;

import design_pattern.structural.bridge.bridge.notification.Notification;
import design_pattern.structural.bridge.AlertRule;
import design_pattern.structural.bridge.prime.ApiStatInfo;

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
            notification.cNotify("...");
        }
    }
}
