package MrMa.multiThread.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * CountDown：等待指定数量的线程结束，之后再干什么。
 * countDown(), await()
 * 可以用join代替。可以在一个线程里countDown多次。
 *
 * @author chenyuqun
 * @date 2020/12/21 9:14 上午
 */
public class CountDownLatchTest {

    private static final CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " execute");
                countDownLatch.countDown();
            });
            thread.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all thread end");
        Exchanger<System> exchanger = new Exchanger<>();
    }

}
