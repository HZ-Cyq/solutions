package multiThreading.MrLiao.M01_thread;

import java.util.concurrent.TimeUnit;

/**
 * @author chenyuqun
 * @date 2021/1/21 6:39 下午
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello world");
        });
        thread.start();
        // 等待500ms之后就不再等待了。
        thread.join(500);
        System.out.println("main end");
    }

}
