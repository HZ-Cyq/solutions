package MrMa.multiThread;

import java.util.concurrent.TimeUnit;

/**
 * @author chenyuqun
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("thread start");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread end");
        });
        thread.start();
        // 虽然主线程结束了，子线程仍可以继续执行。
        System.out.println("main end");
    }
}
