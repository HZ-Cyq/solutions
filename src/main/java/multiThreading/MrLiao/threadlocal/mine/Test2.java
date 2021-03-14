package multiThreading.MrLiao.threadlocal.mine;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 上下文实现AutoCloseable接口，利用try(resource){...}结构,在调用完之后会自动的删掉。
 *
 * @author chenyuqun
 * @date 2021/1/21 11:50 上午
 */
public class Test2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            Task task = new Task(String.valueOf(i));
            executorService.submit(task);
        }
        executorService.shutdown();
    }
}

class Task implements Runnable {
    String userName;

    public Task(String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {
        // UserContext要在run方法里实现，根据这个任务的userName创建UserContext.
        try (UserContext userContext = new UserContext(userName)) {
            System.out.println(Thread.currentThread().getName() + ": " + UserContext.currentUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " clean userContext " + ": " + UserContext.currentUser());
    }
}

class UserContext implements AutoCloseable {
    static final ThreadLocal<String> ctx = new ThreadLocal<>();

    public UserContext(String user) {
        ctx.set(user);
    }

    public static String currentUser() {
        return ctx.get();
    }

    @Override
    public void close() throws Exception {
        ctx.remove();
    }
}
