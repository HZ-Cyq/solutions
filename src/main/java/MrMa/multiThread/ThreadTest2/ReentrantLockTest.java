package MrMa.multiThread.ThreadTest2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

/**
 * 可重入锁， Synchronized是可重入的
 * @author chenyuqun
 * @date 2020/12/3 9:00 上午
 */
public class ReentrantLockTest {
    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("hello"));
        Semaphore semaphore = new Semaphore(1);
        StampedLock stampedLock = new StampedLock();
        stampedLock.readLock();
//        stampedLock.tryConvertToReadLock()
    }
}
