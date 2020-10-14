package design_pattern.creational.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenyuqun
 */
public enum IdGenerator1Enum {

    INSTANCE();

    IdGenerator1Enum() {
        this.id = new AtomicLong(0L);
    }

    private AtomicLong id;

    public long getId() {
        return id.incrementAndGet();
    }
}
