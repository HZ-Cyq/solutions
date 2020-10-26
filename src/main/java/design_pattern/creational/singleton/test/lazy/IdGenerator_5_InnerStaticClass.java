package design_pattern.creational.singleton.test.lazy;

import java.util.concurrent.atomic.AtomicLong;

/**
 * SingletonHandler是一个静态内部类，当外部类被加载的时候，并不会创建SingletonHandler实例对象，只有当调用getInstance方法时，SingleHandler才会被加载，才会创建实例对象
 *
 * @author chenyuqun
 */
public class IdGenerator_5_InnerStaticClass {

    private AtomicLong id = new AtomicLong();


    private IdGenerator_5_InnerStaticClass() {

    }

    private static class SingletonHandler {
        private static final IdGenerator_5_InnerStaticClass instance = new IdGenerator_5_InnerStaticClass();
    }

    public static IdGenerator_5_InnerStaticClass getInstance() {
        return SingletonHandler.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(IdGenerator_5_InnerStaticClass.getInstance().hashCode())).start();
        }
    }
}
