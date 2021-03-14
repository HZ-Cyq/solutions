package multiThreading;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author playcrab_chenyuqun
 */
public class ConcurrentMapTest {
    @Test
    public void testConcurrentMap() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
        map.put("key", 1);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    int key = map.get("key") + 1; //step 1
                    map.put("key", key);//step 2
                }
            });
        }

        try {
            Thread.sleep(3000); //模拟等待执行结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("------" + map.get("key") + "------");
        executorService.shutdown();
    }

    /**
     * 使用synchronized:不管用
     */
    @Test
    public void testSynchronizedTest() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
        map.put("key", 1);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    synchronized (this) {
                        int key = map.get("key") + 1;
                        map.put("key", key);
                    }
                }
            });
        }

        try {
            Thread.sleep(10000); //模拟等待执行结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("------" + map.get("key") + "------");
        executorService.shutdown();
    }

    /**
     * 使用AtomicInteger:管用
     */
    @Test
    public void testAtomicInteger() {
        ConcurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<String, AtomicInteger>();
        AtomicInteger integer = new AtomicInteger(1);
        map.put("key", integer);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    map.get("key").incrementAndGet();
                }
            });
        }

        try {
            Thread.sleep(3000); //模拟等待执行结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("------" + map.get("key") + "------");
        executorService.shutdown();
    }

    @Test
    public void testMap() {
        Map<String, Integer> map = Maps.newHashMap();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        for (String key : map.keySet()) {
            System.out.println("key: " + key + ", value: " + map.get(key));
        }
    }

    /**
     * 测试putIfAbsent和put的返回值：返回旧值【没有就是null】
     */
    @Test
    public void testPutIfAbsent() {
        Map<String, String> map = Maps.newHashMap();
        String re1 = map.putIfAbsent("1", "1");
        String re2 = map.putIfAbsent("1", "2");
        System.out.println(re1 + "," + re2);

        String re3 = map.put("2", "3");
        String re4 = map.put("1", "3");
        System.out.println(re3 + "," + re4);
    }

    @Test
    public void testIterator() {
        Map<String, String> map = Maps.newHashMap();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        System.out.println(map.values().stream().iterator().next());
    }

    @Test
    public void test1() {
        int a = 10;
        print(a);
    }

    private void print(long a) {
        System.out.println(a);
    }

    @Test
    public void testTreeMap() {
        TreeMap<Integer, String> treeMap = Maps.newTreeMap();
        treeMap.put(1, "1");
        treeMap.put(2, "2");
        treeMap.put(3, "3");
        treeMap.put(4, "4");
        treeMap.put(5, "5");
        treeMap.put(6, "6");
        treeMap.put(7, "7");
        treeMap.put(8, "8");
        treeMap.put(9, "9");
        treeMap.put(10, "10");

        System.out.println(treeMap.ceilingKey(7));
        System.out.println(treeMap.ceilingKey(-1));
        System.out.println(treeMap.higherKey(9));



    }

}
