package javabase.map;

import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;

/**
 * @author playcrab_chenyuqun
 */
public class IdentityHashMapTest {

    /**
     * IdentityHashMap和HashMap的区别
     * IdentityHashMap用 "==" 比较key值，HashMap用equals比较
     * https://segmentfault.com/q/1010000002779228/
     */
    @Test
    public void testIdentityHashMap() {
        IdentityHashMap<String, String> iHashMap = Maps.newIdentityHashMap();
        String key1 = "hello";
        String key2 = "hello";
        String key3 = new String("hello");
        String generalValue = "world";

        iHashMap.put(key1, generalValue);
        iHashMap.put(key2, generalValue);
        iHashMap.put(key3, generalValue);
        Assert.assertEquals(2, iHashMap.size());

        HashMap<String, String> hashMap= Maps.newHashMap();
        hashMap.put(key1, generalValue);
        hashMap.put(key2, generalValue);
        hashMap.put(key3, generalValue);
        Assert.assertEquals(1, hashMap.size());
    }
}
