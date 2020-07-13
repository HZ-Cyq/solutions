package designpattern.structural.staticform.static2;

import com.google.common.collect.Lists;
import designpattern.structural.RequestInfo;

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
