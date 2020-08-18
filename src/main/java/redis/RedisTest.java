package redis;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static com.alibaba.fastjson.JSON.parseObject;

/**
 * @author chenyuqun
 */
public class RedisTest {
    /*@Test
    public void testSaveAndLoad() {
        String jsonStr = JSON.toJSONString(MyObject.INSTANCE);
        MyObject.INSTANCE = parseObject(jsonStr);
    }*/

    @Test
    public void test1() {
        int hpRate = (int) (1.0 * 940 / 13918720 * 10000);
        int hpRate2 = (int) (1.0 * 1 / 100000 * 10000);

        System.out.println(hpRate);
        System.out.println(hpRate2);
    }

    @Test
    public void test2() {
        Map<String, String> map = Maps.newHashMap();
        map.put("hello", "world");
        map.put("1", "1");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey());
        }

        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey());
        }
    }
}
