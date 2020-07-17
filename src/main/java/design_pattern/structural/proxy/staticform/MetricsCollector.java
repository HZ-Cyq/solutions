package design_pattern.structural.proxy.staticform;

import com.google.common.collect.Lists;
import design_pattern.structural.proxy.dynamicform.RequestInfo;

import java.util.ArrayList;

/**
 * @author playcrab_chenyuqun
 */
public class MetricsCollector {
    private ArrayList<Object> requestInfoList = Lists.newArrayList();
    public void recordRequest(RequestInfo requestInfo) {
        System.out.println("MetricsCollector.recordRequest: add requestInfo in List, requestInfo: " + requestInfo.toString());
       requestInfoList.add(requestInfo);
    }
}
