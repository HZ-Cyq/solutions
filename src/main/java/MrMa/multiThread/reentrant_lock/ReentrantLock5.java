package MrMa.multiThread.reentrant_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁:并不是完全的公平。
 * 公平锁：新的线程进来的时候，会先看一下排队队列里有没有别的线程，要是有的话就进入队列。
 * 非公平锁：新的线程来的时候可能不看队列，直接就去执行
 *
 * @author chenyuqun
 * @date 2020/12/20 11:53 下午
 */
public class ReentrantLock5 {
    ReentrantLock reentrantLock = new ReentrantLock(true);
    public void m1() {
        for (int i = 0; i < 100; i++) {
            reentrantLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "running");
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock5 reentrantLock5 = new ReentrantLock5();
        Thread thread1 = new Thread(reentrantLock5::m1);
        Thread thread2 = new Thread(reentrantLock5::m1);
        thread1.start();
        thread2.start();
    }
}
