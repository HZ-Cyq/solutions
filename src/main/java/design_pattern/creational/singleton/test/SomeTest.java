package design_pattern.creational.singleton.test;

import design_pattern.creational.singleton.test.hungry.IdGenerator_1_Basic;
import design_pattern.creational.singleton.test.lazy.IdGenerator_3_LazyBasic;
import org.junit.Assert;
import org.junit.Test;

import javax.management.relation.RoleUnresolved;

import static design_pattern.creational.singleton.test.lazy.IdGenerator_3_LazyBasic.getInstance;

/**
 * @author chenyuqun
 */
public class SomeTest {

    @Test
    public void test1() {
        Assert.assertEquals(1, IdGenerator_1_Basic.getInstance().getId());
        Assert.assertEquals(2, IdGenerator_1_Basic.getInstance().getId());
    }

    public class Order {
        public void create() {
            long id = IdGenerator_1_Basic.getInstance().getId();
        }
    }

    public class User {
        public void create() {
            long id = IdGenerator_1_Basic.getInstance().getId();
        }
    }


    @Test
    public void testLazy() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(IdGenerator_3_LazyBasic.getInstance().hashCode());
                System.out.println("hello");
            }).start();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(IdGenerator_3_LazyBasic.getInstance().hashCode());
        }
    }
}
