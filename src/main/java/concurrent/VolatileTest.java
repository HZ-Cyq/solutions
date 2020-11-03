package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author chenyuqun
 */
public class VolatileTest {
    // 如果没有加volatile, 主线程不知道
    static volatile boolean loop = true;

    public static void main(String[] args) {
        Thread tHread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            loop = false;
            System.out.println("thread change loop value");
        });
        tHread.start();

        while (loop) {
            if(!loop) {
                System.out.println("main thread know the change:" + loop);
                System.out.flush();
            }
        }
    }
}
