package MrMa.multiThread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(20));
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.submit(new MyThread(i));
        }
        threadPoolExecutor.shutdown();
    }

    public static class MyThread extends Thread {

        private final int taskNum;

        public MyThread(int taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "执行第" + taskNum + "号任务");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
