package test;

import org.junit.Test;

/**
 * @author chenyuqun
 * @date 2020/11/30 5:10 下午
 */
public class DigitsTest {
    @Test
    public void test1() {
        int a = 2;
        int b = 1;
        if((a = b) == 1) {
            System.out.println("is 1");
        } else {
            System.out.println("not 1");
        }
        System.out.println(a);
    }
}
