package java_language_basic.language_basic;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author playcrab_chenyuqun
 */
public class JavaDataStructTest {

    @Test
    public void test1() {
        double a = 1.232442334;
        int i = (int) a;
        double left = a - i;
        int re = ((int)(left * 100)) % 100;
        System.out.println(re);
    }

    @Test
    public void test2() {
        long a = Long.parseLong("1588155492726");
        System.out.println(a);
        int d = 100;
        long e = (long)d;
        long c = a / e;
        long b = a % e;
        System.out.println(c);
        System.out.println(b);

        long aa = 123123123;
        long bb = 123124;
        long cc = aa / bb;
        System.out.println("cc: " + cc);
    }

    @Test
    public void test3() {
        double a = 123.3;
        a = (long)(a * 100);
        System.out.println(a);
        a /= 100;
        System.out.println(a);
    }

    @Test
    public void test4() {
        int n = (int) Math.pow(10,2);
        double d = Math.pow(10,10) + 100;
        System.out.println(n);
        System.out.println(d);
    }

    @Test
    public void testMax() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);
    }

}
