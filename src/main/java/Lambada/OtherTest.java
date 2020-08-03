package Lambada;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenyuqun
 */
public class OtherTest {
    @Test
    public void test1() {
        int[] a = {1, 2, 3, 4};
//        Stream.of(a).reduce(0, (init, value) -> init + value).intValue();
    }

    @Test
    public void testInitArray() {
        int[] array = new int[] {3,2,1};
        initArray(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    private void initArray(int[] a) {
        a[0] = 1;
        a[1] = 2;
    }
}
