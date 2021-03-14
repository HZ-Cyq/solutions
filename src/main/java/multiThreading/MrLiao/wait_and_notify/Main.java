package multiThreading.MrLiao.wait_and_notify;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyuqun
 * @date 2021/1/20 6:02 下午
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue taskQueue = new TaskQueue();

        Thread thread1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " get : " + taskQueue.getTask());
        });

        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " get : " + taskQueue.getTask());
        });

        Thread thread3 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " get : " + taskQueue.getTask());
        });

        Thread thread4 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " add task...");
            taskQueue.addTask("4");
            System.out.println(Thread.currentThread().getName() + " add task over");
        });

        Thread thread5 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " add task...");
            taskQueue.addTask("5");
            System.out.println(Thread.currentThread().getName() + " add task over");
        });

        Thread thread6 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " add task...");
            taskQueue.addTask("6");
            System.out.println(Thread.currentThread().getName() + " add task over");
        });

        Thread thread7 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " get : " + taskQueue.getTask());
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("thread7 state: "  + thread7.getState());
    }
}

/**
 * 这是一个线程安全的任务队列，多个线程并发添加task或者移除task，能正确执行。
 */
class TaskQueue {

    Queue<String> queue = new LinkedList<>();

    public TaskQueue() {
    }

    public synchronized void addTask(String task) {
        queue.add(task);
        notifyAll();
    }

    public synchronized String getTask() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }
}
