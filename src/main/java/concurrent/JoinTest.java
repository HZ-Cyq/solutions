package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenyuqun
 */
public class JoinTest {

    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger();
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a.set(10);
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 子线程所有对共享变量的修改, 在主线程调用join()之后可见

        System.out.println("a: " + a);
    }
}
