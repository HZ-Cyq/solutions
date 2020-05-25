package javabase.map.stream;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * @author playcrab_chenyuqun
 */
public class StreamTest {

    private static Map<String, Employee> map1 = new HashMap<>();
    private static Map<String, Employee> map2 = new HashMap<>();

    @Test
    public void testAllMatch() {
        Map<String, Integer> map = Maps.newHashMap();
        Boolean re = map.values().stream().allMatch(value -> value == 0);
        System.out.println(re);
    }

    @Test
    public void testMapToInt() {
        Map<String, Integer> items = Maps.newHashMap();
        items.put("item1", 1);
        items.put("item2", 2);
        items.put("item3", 3);
        int sum = items.values().stream().mapToInt(StreamTest::returnInteger).sum();
        System.out.println("sum: " + sum);
    }

    @Test
    public void testMap() {
        Map<String, Integer> map = Maps.newHashMap();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 5);
        map.put("4", 4);
        map.put("5", 3);
        List<Integer> list = map.values().stream().collect(Collectors.toList());
        list.forEach(element -> System.out.println(element));
    }

    @Test
    public void testForEach() {
        List<String> rewards = Lists.newArrayList();
        rewards.add("1");
        rewards.add("2");
        rewards.add("3");
        rewards.add("5");

        List<String> newRewards = Lists.newArrayList();
        rewards.forEach(reward -> newRewards.add(reward));
        newRewards.forEach(reward -> System.out.println(reward));
    }

    public static Integer returnInteger(int a) {
        return new Integer(a + 1);
    }

    @Test
    public void testMax() {
        Map<String, Apple> map = Maps.newHashMap();
        /*Apple apple1 = new Apple("apple1",1);
        Apple apple2 = new Apple("apple2",2);
        Apple apple3 = new Apple("apple3",3);
        Apple apple4 = new Apple("apple4",4);
        Apple apple5 = new Apple("apple5",5);
        map.put("1", apple1);
        map.put("2", apple2);
        map.put("3", apple3);
        map.put("4", apple4);
        map.put("5", apple5);*/
        Apple apple = map.values().stream().max(comparing(Apple::getWeight)).orElse(null);
        System.out.println(apple);
    }

    @Test
    public void testConcat() {

        Map<String, Integer> map1 = ImmutableMap.of("One", 1, "Two", 2);
        Map<String, Integer> map2 = ImmutableMap.of("Three", 3);

        Map<String, Integer> expected = ImmutableMap.of("One", 1, "Two", 2, "Three", 3);
        Map<String, Integer> result = new HashMap<>();

        map1.merge("One", 3, (oldValue, newValue) -> oldValue + newValue);
        result.forEach((k, v) -> System.out.println("key:" + k + " value:" + v));
    }

    @Test
    public void testMerge() {
        String k = "key";
        HashMap<String, Integer> map = new HashMap<>();
        map.merge(k, 2, (oldVal, newVal) -> oldVal + newVal);
        map.forEach((key, v) -> System.out.println("key:" + key + " value:" + v));
    }

    @Test
    public void testFilter() {
        Map<String, Integer> map = Maps.newHashMap();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        List<Integer> list = map.values().stream().filter(key -> key == 5).collect(Collectors.toList());
        list.forEach(value -> System.out.println(value));

        Integer re = map.values().stream().max(comparing(value -> value)).orElse(null);
        System.out.println(re);
    }
}
