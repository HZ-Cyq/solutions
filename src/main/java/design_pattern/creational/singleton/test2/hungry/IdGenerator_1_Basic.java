package design_pattern.creational.singleton.test2.hungry;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenyuqun
 */
public class IdGenerator_1_Basic {

    private static IdGenerator_1_Basic instance = new IdGenerator_1_Basic();

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator_1_Basic() {

    }

    public static IdGenerator_1_Basic getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(IdGenerator_1_Basic.getInstance().hashCode())).start();
        }
    }
}
