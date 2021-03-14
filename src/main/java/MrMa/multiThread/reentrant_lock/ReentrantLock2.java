package MrMa.multiThread.reentrant_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock是可以替代synchronized
 * @author chenyuqun
 * @date 2020/12/19 11:48 下午
 */
public class ReentrantLock2 {
    Lock lock = new ReentrantLock();

    public void m1() {
        try {
        lock.lock(); // synchronized(this)
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
        m2();
    }

    public void m2() {
        try {
            lock.lock();
            System.out.println("m2");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock2 reentrantLock2 = new ReentrantLock2();
        Thread thread = new Thread(reentrantLock2::m1);
        thread.start();
    }
}
