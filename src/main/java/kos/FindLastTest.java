package kos;

import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class FindLastTest {
    @Test
    public void testAddAll() {
        JSONArray array1 = null;
        JSONArray re = new JSONArray(array1);
        JSONArray array2 = null;
        re.addAll(array2);
        System.out.println(re);
    }
}
