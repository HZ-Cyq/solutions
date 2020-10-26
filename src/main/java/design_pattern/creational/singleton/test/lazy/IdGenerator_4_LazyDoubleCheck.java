package design_pattern.creational.singleton.test.lazy;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenyuqun
 */
public class IdGenerator_4_LazyDoubleCheck {

    private AtomicLong id = new AtomicLong();

    private static IdGenerator_4_LazyDoubleCheck instance;

    public static IdGenerator_4_LazyDoubleCheck getInstance() {
        if (instance == null) {
            // 类级别的锁，什么是类级别的锁？是不是当有一个用到IdGenerator_4_LazyDoubleCheck进程进入的时候，另一个进程就进不去了？
            synchronized (IdGenerator_4_LazyDoubleCheck.class) {
                if (instance == null) {
                    instance = new IdGenerator_4_LazyDoubleCheck();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(IdGenerator_4_LazyDoubleCheck.getInstance().hashCode())).start();
        }
    }
}
