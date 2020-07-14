package design_pattern.structural.bridge.bridge.handler;

import design_pattern.structural.bridge.AlertRule;
import design_pattern.structural.bridge.prime.ApiStatInfo;
import design_pattern.structural.bridge.bridge.notification.Notification;

/**
 * @author chenyuqun
 */
public class TpsAlertHandler extends AlertHandler {
    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if(tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTimeoutTps()) {
            System.out.println("TpsAlertHandle notify");
            notification.cNotify("...");
        }
    }
}
