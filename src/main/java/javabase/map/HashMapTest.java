package javabase.map;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chenyuqun
 */
public class HashMapTest {
    private TreeMap<Integer, String> treeMap = Maps.newTreeMap();

    boolean has;

    @Before
    public void initTreeMap() {
        treeMap.put(0, "0");
        treeMap.put(1, "1");
        treeMap.put(2, "2");
        treeMap.put(3, "3");
        treeMap.put(4, "4");
        treeMap.put(5, "5");
        treeMap.put(6, "6");
        treeMap.put(7, "7");
        treeMap.put(8, "8");
        treeMap.put(9, "9");
    }

    @Test
    public void testGetKey() {
        // < 3
        System.out.println(treeMap.lowerKey(3));
        // <= 3
        System.out.println(treeMap.floorKey(3));
        // >= 3
        System.out.println(treeMap.ceilingKey(3));
        // > 3
        System.out.println(treeMap.higherKey(3));
    }

    @Test
    public void testLongMax() {
        System.out.println(Long.MAX_VALUE);
    }

    @Test
    public void test1() {
        Map<String, Integer> map = Maps.newHashMap();
        String str = null;
        if (map.get(str) == null) {
            System.out.println("hello");
        } else {
            System.out.println("world");
        }
    }

    @Test
    public void test2() {
        Map<String, String> map = Maps.newHashMap();
        map.put("1", "2");
        String val = map.get("1");
        val = "3";
        System.out.println(map.get("1"));
    }

    @Test
    public void testIterator() {
        Map<String, String> map = Maps.newHashMap();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        System.out.println(iterator.next().getKey());
        System.out.println(iterator.next().getKey());
    }

    @Test
    public void testNullValue() {
        Map<String, String> map = Maps.newHashMap();
        System.out.println(map.get(null));

        String str = "";
        System.out.println(str.equals(null));
    }
}


