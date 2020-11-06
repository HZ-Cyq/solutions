package design_pattern.creational.prototype;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 02. requirement: 将数据同步到另一个系统中, 要求新系统的数据与原系统一致，一直可用【不存在中间状态】，
 * 要求与原系统数据一致，创建一个新的map，把系统的map存在新的map里，再将currentKeywords指向这个新的map。
 *
 * @author chenyuqun
 */
public class VersionDemo {
    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();

    public void refresh() {
        HashMap<String, SearchWord> newKeyWords = new LinkedHashMap<>();

        // 从数据库中取出所有的数据，放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords();
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            newKeyWords.put(searchWord.getKeyWord(), searchWord);
        }

        currentKeywords = newKeyWords;
    }

    private List<SearchWord> getSearchWords() {
        // TODO: 从数据库中取出所有的数据
        return null;
    }
}
