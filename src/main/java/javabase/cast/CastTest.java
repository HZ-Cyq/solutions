package javabase.cast;

import org.junit.Test;

/**
 * @author chenyuqun
 */
public class CastTest {

    @Test
    public void test1() {
        System.out.println(getLong());
    }

    public Long getLong() {
        int a = 0;
        return (long)a;
    }
}
