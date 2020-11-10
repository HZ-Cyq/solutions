package test.other.proxy.dynamicForm;

/**
 * @author chenyuqun
 * @date 2020/11/10 10:26 上午
 */
public class RequestInfo {
    private String apiName;

    private long startTimeStamp;

    private long responseTime;

    public RequestInfo(String apiName, long startTimeStamp, long responseTime) {
        this.apiName = apiName;
        this.startTimeStamp = startTimeStamp;
        this.responseTime = responseTime;
    }

    @Override
    public String toString() {
        return "RequestInfo{" +
                "apiName='" + apiName + '\'' +
                ", startTimeStamp=" + startTimeStamp +
                ", responseTime=" + responseTime +
                '}';
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public long getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(long startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }
}
