package design_pattern.creational.prototype;

import java.util.HashMap;
import java.util.List;

/**
 * 03 requirement:与02一样，但是实现比02的效率更高
 *
 * @author chenyuqun
 */
public class VersionDemo2 {
    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {
        // 拷贝已有对象的数据，更新少量差值
        // 这里要深拷贝，因为要保证currentKeywords在任何时刻都是同一个版本。
        HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeywords.clone();
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if(searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if(newKeywords.containsKey(searchWord.getKeyWord())) {
                SearchWord oldSearchWord = newKeywords.get(searchWord.getKeyWord());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            } else {
                newKeywords.put(searchWord.getKeyWord(), searchWord);
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 从数据库取出 更新时间 > lastUpdateTime 的数据
        // 这一步是最耗时的，VersionDemo2主要优化的是这一步，减少从数据库中捞数据。
        return null;
    }
}
