package MrMa.multiThread.state;

import java.util.concurrent.TimeUnit;

/**
 * 创建一个线程：NEW
 * 调用start方法：RUNNABLE
 * 线程结束：TERMINATED
 *
 * @author chenyuqun
 * @date 2020/12/2 11:33 下午
 */
public class GetStateTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("create a new thread");
        });
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        // 主线程会等thread线程结束，然后继续执行
        thread.join();
        System.out.println(thread.getState());
    }
}
