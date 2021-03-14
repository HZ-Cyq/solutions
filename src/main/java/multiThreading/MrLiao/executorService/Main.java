package multiThreading.MrLiao.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenyuqun
 * @date 2021/1/20 8:44 下午
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 20; i++) {
            Task task = new Task(String.valueOf(i));
            executor.submit(task);
        }
        executor.shutdown();
    }
}

class Task implements Runnable {
    private String str;

    public Task(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "run with str is " + str);
    }
}
