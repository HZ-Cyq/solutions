package design_pattern.structural.bridge.prime;

import com.google.common.collect.Lists;
import design_pattern.structural.bridge.AlertRule;
import design_pattern.structural.bridge.bridge.notification.Notification;

import java.util.ArrayList;

/**
 * 这个类里存着handlers，用来检查ApiStatInfo
 * @author chenyuqun
 */
public class Alert {
    private AlertRule rule;
    private Notification notification;

    private ArrayList<AlertHandler> alertHandlers = Lists.newArrayList();

    public Alert() {

    }

    public Alert(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public void addAlertHandle(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler handle : alertHandlers) {
            handle.check(apiStatInfo);
        }
    }
}
