package design_pattern.structural.proxy.staticform.static1;

import design_pattern.structural.proxy.RequestInfo;
import design_pattern.structural.proxy.UserVo;
import design_pattern.structural.proxy.staticform.static2.MetricsCollector;

/**
 * @author playcrab_chenyuqun
 */
public class UserController {
    private MetricsCollector metricsCollector = new MetricsCollector();

    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        // 省略login的逻辑
        long endTimestamp = System.currentTimeMillis();
        long responseTime = endTimestamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        // 返回UserVo数据
        return null;
    }

    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        // 省略register的逻辑
        long endTimestamp = System.currentTimeMillis();
        long responseTime = endTimestamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        // 返回UserVo数据
        return null;
    }
}

