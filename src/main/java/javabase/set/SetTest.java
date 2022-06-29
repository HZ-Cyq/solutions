package javabase.set;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Random;
import java.util.Set;

/**
 * @author playcrab_chenyuqun
 */
public class SetTest {
    @Test
    public void testSet() {
        Set<Integer> set = Sets.newHashSet();
        Random random = new Random();
        for(int i = 0; i < 100; i ++) {
            set.add(random.nextInt(100));
        }
        set.forEach(System.out::println);
        System.out.println("size: "+ set.size());
    }
}
