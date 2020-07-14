package design_pattern.structural.bridge;

/**
 * @author chenyuqun
 */
public class Rule {
    int maxErrorCount;
    int maxTimeoutTps;

    public Rule(int maxErrorCount, int maxTimeoutTps) {
        this.maxErrorCount = maxErrorCount;
        this.maxTimeoutTps = maxTimeoutTps;
    }

    public int getMaxErrorCount() {
        return maxErrorCount;
    }

    public void setMaxErrorCount(int maxErrorCount) {
        this.maxErrorCount = maxErrorCount;
    }

    public int getMaxTimeoutTps() {
        return maxTimeoutTps;
    }

    public void setMaxTimeoutTps(int maxTimeoutTps) {
        this.maxTimeoutTps = maxTimeoutTps;
    }
}
