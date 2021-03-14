package multiThreading.MrLiao.future.mine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * completableFuture任务是异步执行的
 *
 * @author chenyuqun
 * @date 2021/1/21 8:41 下午
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Double> completableFuture = CompletableFuture.supplyAsync(CompletableFutureTest::fetchPrice);
        // 如果执行成功
        completableFuture.thenAccept((result) -> {
            System.out.println("success");
        });
        // 如果执行失败
        completableFuture.exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立即结束，否则CompletableFuture默认使用的线程池会立刻关闭
        System.out.println("main begin waiting 2000 ms");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("main end");
    }

    static double fetchPrice() {
        try {
            System.out.println("fetchPrice begin waiting 1000 ms");
            Thread.sleep(1000);
            System.out.println("fetchPrice end waiting");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double d;
        if ((d = Math.random()) < 0.5) {
            throw new RuntimeException("fetch price failed");
        }
        return d;
    }
}
