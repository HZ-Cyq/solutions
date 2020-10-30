package design_pattern.creational.singleton.test2.lazy;


import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenyuqun
 */
public class IdGenerator_3_LazyBasic {
    private static IdGenerator_3_LazyBasic instance;

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator_3_LazyBasic() {

    }

    public static IdGenerator_3_LazyBasic getInstance() {
        if(instance == null) {
            instance = new IdGenerator_3_LazyBasic();
        }
        return instance;
    }
}
