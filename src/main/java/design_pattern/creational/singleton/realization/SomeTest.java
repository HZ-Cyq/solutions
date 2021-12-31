package design_pattern.creational.singleton.realization;

import design_pattern.creational.singleton.realization.hungry.IdGenerator_1_Basic;
import design_pattern.creational.singleton.realization.lazy.IdGenerator_3_LazyBasic;
import org.junit.Assert;
import org.junit.Test;

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

    @Test
    public void test3() {
        long a = 10L;
        long b = 3L;
        System.out.println(a / (double)b * b);
    }

    @Test
    public void teRst4() {
        int n = 10;
        System.out.println(acc(n, 0));
    }

    public int acc(int n, int sum) {
        if(n == 1) {
            return n + sum;
        }
        return acc(n - 1, sum + n);
    }

    @Test
    public void test4() {
        long a = 123214L;
        System.out.println((int)(a * 1.0));
    }
    
}
