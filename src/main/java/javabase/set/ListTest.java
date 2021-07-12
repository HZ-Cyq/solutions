package javabase.set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testRemoveAll() {
        List<Integer> allGrids = IntStream.range(0, 20).boxed().collect(Collectors.toList());
        List<Integer> lightenGrids = Lists.newArrayList();
        lightenGrids.add(300);
        lightenGrids.add(200);
        boolean bool = allGrids.removeAll(lightenGrids);
        for (Integer allGrid : allGrids) {
            System.out.println(allGrid);
        }
        System.out.println(bool);
    }

    @Test
    public void testContainsAll() {
        List<Integer> list = IntStream.range(0, 20).boxed().collect(Collectors.toList());
        List<Integer> list2 = IntStream.range(10, 15).boxed().collect(Collectors.toList());
        System.out.println(list.containsAll(list2));
    }

    @Test
    public void testUnmodifiableSet() {
        HashMap<String, String> map = Maps.newHashMap();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");

        Set<String> set = getSet(map);
        set.add("6");
        for (String s : set) {
            System.out.println(s);
        }

        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println(stringStringEntry.getKey() + ":" + stringStringEntry.getValue());
        }
    }

    public Set<String> getSet(Map<String, String> map) {
        return Collections.unmodifiableSet(map.keySet());
    }
}
