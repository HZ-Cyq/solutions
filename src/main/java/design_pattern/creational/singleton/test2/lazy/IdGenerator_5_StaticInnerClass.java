package design_pattern.creational.singleton.test2.lazy;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenyuqun
 */
public class IdGenerator_5_StaticInnerClass {

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator_5_StaticInnerClass() {

    }

    public static class SingletonHandler {
        private static final IdGenerator_5_StaticInnerClass instance = new IdGenerator_5_StaticInnerClass();
    }

    public static IdGenerator_5_StaticInnerClass getInstance() {
        return SingletonHandler.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(IdGenerator_5_StaticInnerClass.getInstance().hashCode())).start();
        }
    }
}
