package multiThreading;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author playcrab_chenyuqun
 */
public class TestThread {
    @Test
    public void testThread() {
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();
    }

    @Test
    public void testThread1() {
        MyThread1 mythread = new MyThread1();
        //下列线程都是通过mythread对象创建的
        Thread a = new Thread(mythread, "A");
        Thread b = new Thread(mythread, "B");
        Thread c = new Thread(mythread, "C");
        Thread d = new Thread(mythread, "D");
        Thread e = new Thread(mythread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    @Test
    public void testPoolThread() {
        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        PoolThread p1 = new PoolThread();
        PoolThread p2 = new PoolThread();
        PoolThread p3 = new PoolThread();
        PoolThread p4 = new PoolThread();
        PoolThread p5 = new PoolThread();

        // 将线程放入池子中进行执行
        pool.execute(p1);
        pool.execute(p2);
        pool.execute(p3);
        pool.execute(p4);
        pool.execute(p5);
        // 关闭线程池子
        pool.shutdown();
    }
}
