package test.other.proxy.staticForm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chenyuqun
 */
public class MetricsCollector {
    List<RequestInfo> infos = Lists.newArrayList();

    public void recordInfo(RequestInfo requestInfo) {
        infos.add(requestInfo);
        System.out.println("metricsCollector record info: " + requestInfo);
    }
}
