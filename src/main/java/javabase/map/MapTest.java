package javabase.map;

import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 参考《码出高效》6.8章
 * <p>
 * Map类使用一定的哈希算法形成的一组比较均匀的哈希值作为Key，Value挂在Key上。
 * 没有重复的Key，可以有多个重复的Value
 *
 * @author chenyuqun
 * @date 2022/3/18 6:49 下午
 */
public class MapTest {
    /**
     * Map接口除提供传统的增删改查方式之外，还有三个Map类特有的方法。
     * 即返回所有的Key，返回所有的Value，返回所有的KV键值对。
     * 通常这些视图支持清楚操作，但是修改和增加会抛异常。
     */
    @Test
    public void testMap() {
        HashMap<String, String> hashMap = Maps.newHashMap();
        hashMap.put("1", "1");
        hashMap.put("2", "2");
        Set<String> strings = hashMap.keySet();
        strings.remove("1");
        Assert.assertEquals("{2=2}", hashMap.toString());
        strings.clear();
        Assert.assertEquals("{}", hashMap.toString());
        boolean hasException = false;
        try {
            strings.add("2");
        } catch (UnsupportedOperationException exception) {
            hasException = true;
        }
        Assert.assertTrue(hasException);
    }

    /**
     * HashMap的key和value都可以为空
     * TreeMap的key不能为空，value可以为空
     * ConcurrentHashMap的key和value都可以为空
     */
    @Test
    public void nullTest() {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null, null);
        Assert.assertEquals("{null=null}", hashMap.toString());

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("", null);
        Assert.assertEquals("{=null}", treeMap.toString());
        boolean hasException = false;
        try {
            treeMap.put(null, "");
        } catch (Exception exception) {
            hasException = true;
        }
        Assert.assertTrue(hasException);

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        hasException = false;
        try {
            concurrentHashMap.put("", null);
        } catch (Exception exception) {
            hasException = true;
        }
        Assert.assertTrue(hasException);
        Assert.assertTrue(concurrentHashMap.isEmpty());
    }

    /**
     * NavigableMap接口继承了SortedMap接口，根据指定的搜索条件返回最匹配的Key-Value元素
     */
    @Test
    public void testTreeMapMethod() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            treeMap.put(String.valueOf(i), String.valueOf(i));
        }
        Assert.assertEquals("6", treeMap.higherKey("5"));
        Assert.assertEquals("4", treeMap.lowerKey("5"));
        Assert.assertEquals("5", treeMap.floorKey("5"));
        Assert.assertEquals("5", treeMap.ceilingKey("5"));
        treeMap.remove("5");
        Assert.assertEquals("4", treeMap.floorKey("5"));
        Assert.assertEquals("6", treeMap.ceilingKey("5"));
    }


    /**
     * HashMap是通过HashCode实现去重
     * TreeMap是依靠Comparable或Comparator实现key的去重
     */
    @Test
    public void testDuplicateRemoval() {
        HashMap<Key, String> hashMap = Maps.newHashMap();
        hashMap.put(new Key(), "hello");
        hashMap.put(new Key(), "world");
        Assert.assertEquals(1, hashMap.size());
        TreeMap<Key, String> treeMap = Maps.newTreeMap();
        treeMap.put(new Key(), "hello");
        treeMap.put(new Key(), "world");
        Assert.assertEquals(2, treeMap.size());
    }
}
