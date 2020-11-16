package design_pattern.structural.bridge.bridge;

import com.google.common.collect.Lists;
import design_pattern.structural.bridge.bridge.handler.AlertHandler;
import design_pattern.structural.bridge.prime.ApiStatInfo;

import java.util.ArrayList;

/**
 * 这个类将apiStateInfo给不同的AlertHandler去检查.
 * 不同的AlertHandler，有不同的不同的Notification
 * 增加Notification的子类：添加不同的Notification
 * 增加AlertHandler的子类：添加不同的AlertHandler
 * 然后统一在{@link ApplicationContext#initializeBeans()}中添加
 *
 * @author chenyuqun
 */
public class Alert {
    private ArrayList<AlertHandler> alertHandlers = Lists.newArrayList();

    public Alert() {

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
