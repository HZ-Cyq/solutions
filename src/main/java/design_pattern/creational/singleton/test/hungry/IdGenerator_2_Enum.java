package design_pattern.creational.singleton.test.hungry;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenyuqun
 */
public enum IdGenerator_2_Enum {

    ID_GENERATOR_2_ENUM(new AtomicLong(0L));

    IdGenerator_2_Enum(AtomicLong id) {
        this.id = id;
    }

    public long getId() {
        return this.id.getAndIncrement();
    }

    private AtomicLong id;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(ID_GENERATOR_2_ENUM.hashCode())).start();
        }
    }
}
