package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenyuqun
 */

public class Test {

    private static AtomicInteger count = new AtomicInteger(0);

    private static long countL;


    public static void main(String[] args) {
        testAdd();
        testAddL();
    }

    public static void testAdd() {
        Thread th1 = new Thread(Test::add100K);
        Thread th2 = new Thread(Test::add100K);
        th1.start();
        th2.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(countL);
    }

    public static void testAddL() {
        Thread th1 = new Thread(Test::add100KL);
        Thread th2 = new Thread(Test::add100KL);
        th1.start();
        th2.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(countL);
    }

    public static void add100K() {
        int j = 0;
        while (j < 100000) {
            count.incrementAndGet();
            j++;
        }
    }

    /**
     * 对Test类上锁，实际上是对Test.class对象上锁，
     * 同时只能有一个Test类执行这段代码。
     */
    public synchronized static void add100KL() {
        int j = 0;
        while (j < 100000) {
            countL++;
            j++;
        }
    }

}
