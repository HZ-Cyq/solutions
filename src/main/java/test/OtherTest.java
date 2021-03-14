package test;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenyuqun
 */
public class OtherTest {


    public static void main(String[] args) {
        A a = new A();
        A b = a;
        b.setA(2);
        System.out.println(a.getA());
    }

    @Test
    public void testFindMin() {
        int[] nums = new int[10];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;
        nums[5] = 2;
        nums[6] = 3;
        nums[7] = 4;
        nums[8] = 7;
        nums[9] = 20;
        Arrays.sort(nums);
    }

    @Test
    public void test2() {
        System.out.println(0b10);
    }
}
