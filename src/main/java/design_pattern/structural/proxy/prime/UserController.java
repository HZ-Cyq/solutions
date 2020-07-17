package design_pattern.structural.proxy.prime;

import design_pattern.structural.proxy.dynamicform.RequestInfo;
import design_pattern.structural.proxy.dynamicform.UserVo;
import design_pattern.structural.proxy.staticform.MetricsCollector;

/**
 * UserController最基本的实现方法。metricsCollector统计方法的执行时间。
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

