package multiThreading.threadpool;

import com.google.common.collect.Queues;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenyuqun
 * @date 2021/11/16 1:13 下午
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        // 创建一个固定大小的线程池:
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        // 关闭线程池:
        es.shutdown();
        Queue<String> q = Queues.newLinkedBlockingDeque(1);
        boolean a = q.add("a");
        System.out.println("a: " + a);
        boolean b = q.add("b");
        System.out.println("b: " + b);
        for (String s : q) {
            System.out.println(s);
        }
    }

    static class Task implements Runnable {
        private final String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("start task " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("end task " + name);
        }
    }
}
