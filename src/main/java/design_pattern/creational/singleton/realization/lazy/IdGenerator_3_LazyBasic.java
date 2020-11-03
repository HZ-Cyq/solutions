package design_pattern.creational.singleton.realization.lazy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 不支持并发。
 *
 * @author chenyuqun
 */
public class IdGenerator_3_LazyBasic {
    private AtomicLong id;

    private static IdGenerator_3_LazyBasic instance;

    private IdGenerator_3_LazyBasic() {

    }

    public static IdGenerator_3_LazyBasic getInstance() {
        // 这儿可能会new两个instance
        if (instance == null) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new IdGenerator_3_LazyBasic();
        }
        return instance;
    }

    public long getId() {
        return id.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(IdGenerator_3_LazyBasic.getInstance().hashCode())).start();
        }
    }
}
