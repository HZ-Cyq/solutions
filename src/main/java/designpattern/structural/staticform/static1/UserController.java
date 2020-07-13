package designpattern.structural.staticform.static1;

import designpattern.structural.RequestInfo;
import designpattern.structural.staticform.static2.MetricsCollector;
import designpattern.structural.UserVo;

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

