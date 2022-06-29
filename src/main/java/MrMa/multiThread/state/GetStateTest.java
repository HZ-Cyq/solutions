package MrMa.multiThread.state;

import java.util.HashMap;
import java.util.PriorityQueue;
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
//        Thread thread = new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("create a new thread");
//        });
//        System.out.println(thread.getState());
//        thread.start();
//        System.out.println(thread.getState());
//        // 主线程会等thread线程结束，然后继续执行
//        thread.join();
//        System.out.println(thread.getState());
        Runnable runnable = new Runnable() {
            @Override
            public synchronized void run() {
                System.out.println("before run");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("after run");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("notify");
        try {
            thread.notify();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Thread thread = new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        System.out.println(thread.getState());
//        thread.start();
//        System.out.println(thread.getState());
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println(thread.getState());
//        thread.join();
//        System.out.println(thread.getState());
        PriorityQueue priorityQueue = new PriorityQueue();
    }
}