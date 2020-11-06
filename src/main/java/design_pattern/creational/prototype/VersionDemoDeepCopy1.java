package design_pattern.creational.prototype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenyuqun
 */
public class VersionDemoDeepCopy1 {
    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();

    private long lastUpdateTime = -1;

    public void refresh() {
        // Deep copy, 递归拷贝对象
        HashMap<String, SearchWord> newKeyWords = new HashMap<>();
        for (Map.Entry<String, SearchWord> e : currentKeywords.entrySet()) {
            SearchWord searchWord = e.getValue();
            SearchWord newSearchWord = new SearchWord(searchWord.getKeyWord(), searchWord.getCount(), searchWord.getLastUpdateTime());
            newKeyWords.put(e.getKey(), newSearchWord);
        }

        // 从数据库中取出 更新时间 > lastUpdateTime 的数据， 放入到newKeywords中
        List<SearchWord> toBeUpdateSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdateSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeyWords.containsKey(searchWord.getKeyWord())) {
                SearchWord oldSearchWord = newKeyWords.get(searchWord.getKeyWord());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            } else {
                newKeyWords.put(searchWord.getKeyWord(), searchWord);
            }
        }

        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeyWords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 从数据库中取出 更新时间 > lastUpdateTime的数据
        return null;
    }
}
