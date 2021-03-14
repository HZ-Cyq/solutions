package multiThreading.MrLiao.wait_and_notify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用threadLocal，在一个线程中，存储同一个对象.
 *
 * @author chenyuqun
 * @date 2021/1/21 11:06 上午
 */
public class Test1 {
    static ThreadLocal<User> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    test1.process(new User("user" + finalI, 0));
                }
            };
            executorService.submit(runnable);
        }
        executorService.shutdown();
    }

    public void process(User user) {
        // 使用完thread1里的值之后，要清理掉.因为thread1还会出来别的user
        try {
            threadLocal.set(user);
            step1();
            step2();
        } finally {
            threadLocal.remove();
        }
    }

    public void step1() {
        User user = threadLocal.get();
        log(user.toString());
    }

    public void step2() {
        User user = threadLocal.get();
        log(user.toString());
    }

    public static void log(String logInfo) {
        System.out.println(Thread.currentThread().getName() + ": " + logInfo);
    }
}

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
