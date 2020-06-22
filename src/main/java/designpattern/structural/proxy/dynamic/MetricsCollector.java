package designpattern.structural.proxy.dynamic;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author playcrab_chenyuqun
 */
public class MetricsCollector {
    List<RequestInfo> requestInfo = Lists.newArrayList();
    public void recordRequest(RequestInfo requestInfo) {
        this.requestInfo.add(requestInfo);
        System.out.println("MetricsCollector.recordRequest: add requestInfo in List, requestInfo: " + requestInfo.toString());
    }
}

