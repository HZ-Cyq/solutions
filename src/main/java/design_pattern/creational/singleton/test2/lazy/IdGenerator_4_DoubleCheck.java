package design_pattern.creational.singleton.test2.lazy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 既支持高并发，又支持延迟加载
 *
 * @author chenyuqun
 */
public class IdGenerator_4_DoubleCheck {
    private static IdGenerator_4_DoubleCheck instance;

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator_4_DoubleCheck() {

    }

    public static IdGenerator_4_DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (IdGenerator_4_DoubleCheck.class) {
                // 这里为什么还要判一次空？
                if (instance == null) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new IdGenerator_4_DoubleCheck();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(IdGenerator_4_DoubleCheck.getInstance().hashCode())).start();
        }
    }

}
