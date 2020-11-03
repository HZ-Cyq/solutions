package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author chenyuqun
 */
public class VolatileTest {
    // 如果没有加volatile, 主线程不知道该值的变化，会在while循环里卡死。
    static volatile boolean loop = true;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            loop = false;
            System.out.println("thread change loop value");
        });
        thread.start();

        while (loop) {

        }

        System.out.println("main thread know loop change: " + loop);
    }
}
