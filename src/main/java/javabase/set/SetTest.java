package javabase.set;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
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

    @Test
    public void testRemove() {
        Set<Integer> set = Sets.newHashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            set.remove(2);
            System.out.println(next);
        }
    }

    @Test
    public void testIterator() {
        HashSet<Integer> set = new HashSet<>();

    }
}
