package design_pattern.creational.prototype;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 01. requirement:将数据同步到另一个系统中
 * 定时的更新部分数据到currentKeyWords中
 */
public class Demo {
    private ConcurrentHashMap<String, SearchWord> currentKeyWords = new ConcurrentHashMap();
    private long lastUpdateTime = -1;

    public void refresh() {
        // 从数据库中取出 更新时间 > lastUpdateTime的数据, 放入到currentKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (currentKeyWords.containsKey(searchWord.getKeyWord())) {
                // 这里为什么不put, 而是用replace? 为了提高效率？
                currentKeyWords.replace(searchWord.getKeyWord(), searchWord);
            } else {
                currentKeyWords.put(searchWord.getKeyWord(), searchWord);
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // 从数据库中取出 更新时间 > LastUpdateTime的数据
        return null;
    }
}

