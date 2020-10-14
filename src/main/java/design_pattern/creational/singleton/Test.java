package design_pattern.creational.singleton;

import org.junit.Assert;
import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * @author chenyuqun
 */
public class Test {

    @org.junit.Test
    public void testBasic() {
        int hashCode = IdGenerator1Basic.getInstance().hashCode();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() ->  Assert.assertEquals(hashCode, IdGenerator1Basic.getInstance().hashCode()));
            thread.start();
        }
    }

    @org.junit.Test
    public void testEnum() {
        int hashCode = IdGenerator1Enum.INSTANCE.hashCode();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> Assert.assertEquals(hashCode, IdGenerator1Enum.INSTANCE.hashCode()));
            thread.start();
        }
    }

    @org.junit.Test
    public void testLazy() {
        int hashCode = IdGenerator2Lazy.getInstance().hashCode();
        for (int i = 0; i < 100; i++) {
            //Thread thread = new Thread(() ->  Assert.assertEquals(hashCode, IdGenerator2Lazy.getInstance().hashCode()));
            Thread thread = new Thread(() -> System.out.println(IdGenerator2Lazy.getInstance().hashCode()));
            thread.start();
        }
    }

}
