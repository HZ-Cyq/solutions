package design_pattern.structural.proxy.dynamicform;

/**
 * @author playcrab_chenyuqun
 */
public class RequestInfo {
    private String apiName;
    private long responseTIme;
    private long startTimestamp;
    public RequestInfo(String apiName, long responseTime, long startTimestamp) {
        this.apiName = apiName;
        this.responseTIme = responseTime;
        this.startTimestamp = startTimestamp;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public long getResponseTIme() {
        return responseTIme;
    }

    public void setResponseTIme(long responseTIme) {
        this.responseTIme = responseTIme;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    @Override
    public String toString() {
        return "RequestInfo: apiName: " + apiName + " responseTime: " + responseTIme + " startTimestamp: " + startTimestamp;
    }
}
