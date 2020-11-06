package design_pattern.creational.prototype;

import java.io.Serializable;

/**
 * @author chenyuqun
 */
public class SearchWord implements Serializable {
    private String keyWord;
    private long count;
    private long lastUpdateTime;

    public SearchWord(String keyWord, long count, long lastUpdateTime) {
        this.keyWord = keyWord;
        this.count = count;
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "SearchWord{" +
                "keyWord='" + keyWord + '\'' +
                ", count=" + count +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
