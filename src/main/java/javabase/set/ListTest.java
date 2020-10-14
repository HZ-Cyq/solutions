package javabase.set;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author playcrab_chenyuqun
 */
public class ListTest {
    @Test
    public void testAddFirst() {
        LinkedList<String> list = Lists.newLinkedList();
        list.add("hello");
        list.add("world");
        list.addFirst("first");
        list.addLast("last");
        list.stream().forEach(ele -> System.out.println(ele));
    }

    @Test
    public void testIterator() {
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println(iterator.next());
        }
    }
}
