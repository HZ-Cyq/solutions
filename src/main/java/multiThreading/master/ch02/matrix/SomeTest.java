package multiThreading.master.ch02.matrix;

import java.util.concurrent.TimeUnit;

/**
 * @author chenyuqun
 * @date 2021/1/12 3:50 下午
 */
public class SomeTest {
    public SomeTest(Integer a) {
        System.out.println("hello world: " + a);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    System.out.println("hello");
                    TimeUnit.SECONDS.sleep(2);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        System.out.println(Runtime.getRuntime().availableProcessors());
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
