package design_pattern.creational.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenyuqun
 */
public class IdGenerator1Basic {
    private static final IdGenerator1Basic instance = new IdGenerator1Basic();
    private AtomicLong id = new AtomicLong(0L);

    private IdGenerator1Basic() {

    }

    public static IdGenerator1Basic getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
