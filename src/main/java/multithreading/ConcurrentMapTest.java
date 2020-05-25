package multithreading;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;
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
        Map<String , Integer> map = Maps.newHashMap();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        for(String key: map.keySet()) {
            System.out.println("key: " + key + ", value: " + map.get(key));
        }
    }
}
