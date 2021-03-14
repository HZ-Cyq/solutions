package MrMa.multiThread.reentrant_lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock的tryLock方法:在指定的时间内尝试获取锁，如果获取到了，返回true,否则返回false;
 * @author chenyuqun
 * @date 2020/12/20 12:07 上午
 */
public class ReentrantLock3 {
    Lock lock = new ReentrantLock();

    public void m1() {
        try {
            lock.lock();
            for (int i = 0; i < 3; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m2() {
        boolean isLock = false;
        try {
            isLock = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println(isLock);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (isLock) lock.unlock();
        }


    }

    public static void main(String[] args) {
        ReentrantLock3 reentrantLock3 = new ReentrantLock3();
        Thread thread1 = new Thread(reentrantLock3::m1);
        Thread thread2 = new Thread(reentrantLock3::m2);
        thread1.start();
        thread2.start();


    }
}
