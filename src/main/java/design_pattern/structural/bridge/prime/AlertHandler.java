package design_pattern.structural.bridge.prime;

import design_pattern.structural.bridge.AlertRule;

/**
 *
 * @author chenyuqun
 */
public abstract class AlertHandler {
    protected AlertRule rule;
    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo apiStatInfo);
}
