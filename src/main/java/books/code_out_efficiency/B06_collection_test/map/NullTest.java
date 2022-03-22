package books.code_out_efficiency.B06_collection_test.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chenyuqun
 * @date 2022/3/4 10:52 上午
 */
public class NullTest {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(null, null);
        System.out.println(hashMap);
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put(null,"null");
        System.out.println(treeMap);
    }
}
