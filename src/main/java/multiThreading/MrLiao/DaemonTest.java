package multiThreading.MrLiao;

import java.util.concurrent.TimeUnit;

/**
 * 默认是用户线程，用户线程之间是相互独立的
 * 守护线程：在用户线程结束后，守护线程也会
 *
 * @author chenyuqun
 * @date 2021/1/18 5:33 下午
 */
public class DaemonTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread1();
        // 如果 thread 是守护进程，main线程结束后，tread线程也会结束
        // 如果 thread 是用户进程，main线程结束后，thread线程也不会结束
        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread sleep 3 sec...");
        Thread.sleep(3000);
        System.out.println("main thread end");

    }
}

class Thread1 extends Thread {

    public void run() {
        for (; ; ) {
            System.out.println("Thread-1: running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
