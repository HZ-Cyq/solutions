package javabase.map.stream;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.taobao.api.internal.util.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;

/**
 * @author playcrab_chenyuqun
 */
public class StreamTest {

    private static Map<String, Employee> map1 = new HashMap<>();
    private static Map<String, Employee> map2 = new HashMap<>();

    private static String apply(Integer ele) {
        return String.valueOf(ele);
    }

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
        map.merge(k, 2, Integer::sum);
        map.forEach((key, v) -> System.out.println("key:" + key + " value:" + v));
    }

    @Test
    public void testFilter() {
        Map<String, Integer> map = Maps.newHashMap();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        List<Integer> list = map.values().stream().filter(key -> key == 3 || key == 2).collect(Collectors.toList());
        for (Integer integer : list) {
            System.out.println(integer);
        }

        Integer re = map.values().stream().max(comparing(value -> value)).orElse(null);
        System.out.println(re);
    }

    /**
     *
     */
    @Test
    public void testPrint() {
        System.out.println("hello");
    }

    /**
     *
     */
    @Test
    public void testSendRewardMail() {
        TreeMap<Integer, String> treeMap = Maps.newTreeMap();
        treeMap.put(1, "1");
        treeMap.put(3, "3");
        treeMap.put(2, "2");
        treeMap.put(4, "4");
        treeMap.put(8, "8");
        treeMap.put(9, "9");
        treeMap.put(10, "10");
        treeMap.put(11, "11");
        treeMap.put(5, "5");
        treeMap.put(6, "6");
        treeMap.put(7, "7");

        String rewardId = null;
        Integer start = null;
        int size = 100;
        int lastKey = treeMap.lastKey();
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            // 遍历第一个entry,初始化rewardId和start.
            if (rewardId == null) {
                start = entry.getKey();
                rewardId = entry.getValue();
                continue;
            }

            sendRewardMail(start, entry.getKey(), rewardId);
            start = entry.getKey();
            rewardId = entry.getValue();

            // 遍历最后一个，如果entry的value不为空，排名从key到最后一名都发奖励。
            if (start == lastKey && !StringUtils.isEmpty(rewardId)) {
                sendRewardMail(start, size, rewardId);
            }
        }
    }

    public void sendRewardMail(int begin, int end, String value) {
        System.out.println("begin: " + begin + ", end: " + end + ", value: " + value);
    }

    @Test
    public void testForEach1() {
        Map<String, Integer> map = Maps.newHashMap();
        map.put("1", 1);
        map.put("2", 2);
        map.entrySet().forEach(entry -> entry.setValue(0));
        map.forEach((key, value) -> System.out.println(key + value));
    }

    @Test
    public void test1() {
        for(int i = 0; i < getList().size(); i++) {
            System.out.println(i);
        }
    }

    public List<String> getList() {
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        System.out.println("get List");
        return list;
    }

    @Test
    public void testStreamRange() {
        List<String> ret = IntStream.range(0,10).boxed().map(String::valueOf).collect(Collectors.toList());
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
        }
    }
}
