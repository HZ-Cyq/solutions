package multiThreading.MrLiao.future.mine;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author chenyuqun
 * @date 2021/1/21 4:18 下午
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task task = new Task("1");
        Future<String> future = executorService.submit(task);
        // 超过500ms，抛异常。
        try {
            String result = future.get(1500, TimeUnit.MILLISECONDS);
            System.out.println(result);
        } finally {
            executorService.shutdown();
        }
    }
}

class Task implements Callable<String> {
    String str;

    public Task(String str) {
        this.str = str;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return str + "..";
    }
}
