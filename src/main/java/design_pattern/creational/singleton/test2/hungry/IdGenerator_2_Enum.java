package design_pattern.creational.singleton.test2.hungry;

import java.util.concurrent.atomic.AtomicLong;

public enum IdGenerator_2_Enum {
    ID_GENERATOR_2_ENUM;

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(ID_GENERATOR_2_ENUM.hashCode())).start();
        }
    }
}
