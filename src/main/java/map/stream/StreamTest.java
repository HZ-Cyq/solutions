package map.stream;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * @author playcrab_chenyuqun
 */
public class StreamTest {
    @Test
    public void testAllMatch() {
        Map<String,Integer> map = Maps.newHashMap();
        Boolean re = map.values().stream().allMatch(value -> value == 0);
        System.out.println(re);
    }
}
