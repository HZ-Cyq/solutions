package test.other.proxy.dynamicForm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chenyuqun
 * @date 2020/11/10 10:22 上午
 */
public class MetricsCollector {
    List<RequestInfo> list = Lists.newArrayList();

    public void addRequestInfo(RequestInfo requestInfo) {
        list.add(requestInfo);
        System.out.println("MetricsCollector addRequestInfo: " + requestInfo);
    }

}
