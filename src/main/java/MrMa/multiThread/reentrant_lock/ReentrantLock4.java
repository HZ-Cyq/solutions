package MrMa.multiThread.reentrant_lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 打断线程的等待
 * synchronized wait之后需要notify才能响应
 * reentrantLock 可以用 lockInter
 * @author chenyuqun
 * @date 2021/1/2 11:40 下午
 */
public class ReentrantLock4 {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            try{
                lock.lock();
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t1 end");
            } catch (Exception e) {

            } finally {
              lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            try{
                lock.lockInterruptibly();
                System.out.println("t2 start");
                System.out.println("t2 end");
            } catch (Exception e) {
                System.out.println("t2 interrupt");
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(2L);
        t2.interrupt();

    }
}
