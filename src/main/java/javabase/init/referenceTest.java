package javabase.init;

import org.junit.Test;

/**
 * @author chenyuqun
 * @date 2020/12/17 10:38 上午
 */
public class referenceTest {
    A a;
    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    public void initA(A aa) {
    }

    @Test
    public void test2() {
        int a = 0;
        System.out.println(a++);
        int b = 0;
        System.out.println(++b);
    }

    @Test
    public void test3() {
        String a;
        String b;
        a = "1";
        b = a;
        a = "2";
        System.out.println(a);
        System.out.println(b);
    }
}
