package design_pattern.structural.bridge.bridge.handler;

import design_pattern.structural.bridge.bridge.notification.Notification;
import design_pattern.structural.bridge.AlertRule;
import design_pattern.structural.bridge.prime.ApiStatInfo;

/**
 * 这个类的check方法，需要子类去实现，因为在具体的子类中去实现不同的检查方法和不同的报警类型。
 * 这里用到了桥接，因为AlertHandler是一个抽象类，Notification也是一个抽象类。AlertHandler里有Notification变量。这就是桥接关键的地方.
 * 以此为标志来判断是否是桥接。
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
