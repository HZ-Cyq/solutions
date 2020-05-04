package javabase.set;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.LinkedList;

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
}
