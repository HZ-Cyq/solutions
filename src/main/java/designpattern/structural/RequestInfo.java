package designpattern.structural;

/**
 * @author playcrab_chenyuqun
 */
public class RequestInfo {
    private String requestType;
    private long responseTime;
    private long startTimestamp;

    public RequestInfo(String requestType, long responseTime, long startTimestamp) {
        this.requestType = requestType;
        this.responseTime = responseTime;
        this.startTimestamp = startTimestamp;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    @Override
    public String toString() {
        return "requestType: " + requestType + " responseTime: " + responseTime + " startTimestamp: " + startTimestamp;
    }
}
