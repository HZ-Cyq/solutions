package set;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

/**
 * @author playcrab_chenyuqun
 */
public class setTest {
    @Test
    public void testSet() {
        Set<Integer> set = Sets.newHashSet();
        set.add(1);
        set.add(2);
        set.add(2);
        set.forEach(o -> System.out.println(o));
        System.out.println("size: "+ set.size());
    }
}
