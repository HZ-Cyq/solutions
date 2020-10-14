package design_pattern.creational.singleton;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenyuqun
 */
public class IdGenerator2Lazy {
    private static IdGenerator2Lazy instance;

    private AtomicLong id;

    private IdGenerator2Lazy() {

    }

    public static IdGenerator2Lazy getInstance() {
        if (instance == null) {
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new IdGenerator2Lazy();
            System.out.println("hello");
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
