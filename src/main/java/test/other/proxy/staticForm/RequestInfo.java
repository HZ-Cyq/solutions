package test.other.proxy.staticForm;

/**
 * @author chenyuqun
 */
public class RequestInfo {
    private String apiName;

    private long responseTime;

    private long startTimeStamp;

    public RequestInfo(String apiName, long responseTime, long startTimeStamp) {
        this.apiName = apiName;
        this.responseTime = responseTime;
        this.startTimeStamp = startTimeStamp;
    }

    @Override
    public String toString() {
        return "RequestInfo{" +
                "apiName='" + apiName + '\'' +
                ", responseTime=" + responseTime +
                ", startTimeStamp=" + startTimeStamp +
                '}';
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public long getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(long startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }
}
