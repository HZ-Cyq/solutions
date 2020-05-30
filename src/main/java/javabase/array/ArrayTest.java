package javabase.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author playcrab_chenyuqun
 */
public class ArrayTest {
    @Test
    public void testArray() {
        int[] array = initCombatDay(2);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public int[] initCombatDay(int expireDay) {
        int[] combatDay = new int[expireDay + 1];
        for (int i = 0; i < expireDay + 1; i++) {
            combatDay[i] = i + 1;
        }
        return combatDay;
    }

    @Test
    public void initArray() {
        int arrayLength = 10;

        // 初始化一个长度为10，每一个元素都是0的数组
        int[] array = new int[arrayLength];
        Assert.assertEquals(arrayLength, array.length);
        for (int i = 0; i < arrayLength; i++) {
            Assert.assertEquals(array[i], 0);
        }

        // 申请一个长度为0的数组
        int[] nullArray1 = {};
        Assert.assertEquals(0, nullArray1.length);

        int[] nullArray2 = new int[0];
        Assert.assertEquals(0, nullArray2.length);
    }

    @Test
    public void testCopyOfRange() {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = i;
        }

        // 包含1、不包含3
        int[] array1 = Arrays.copyOfRange(array, 1, 3);
        print_array(array1);
        // 超过的补0
        int[] array2 = Arrays.copyOfRange(array, 1, 20);
        print_array(array2);

        // 复制整个数组,正好from是0，to是array.length
        int[] array3 = Arrays.copyOfRange(array, 0, array.length);
        print_array(array3);

        // 会报的错误：
        // ArrayIndexOutOfBoundsException - if from < 0 or from > original.length
        // IllegalArgumentException - if from > to
        // NullPointerException - if original is null
        int[] array4 = null;
        int[] array5 = null;
        int[] array6 = null;
        int[] array7 = null;

        try {
            array4 = Arrays.copyOfRange(array, -1, array.length);
        } catch (Exception exception) {
            Assert.assertTrue(exception instanceof ArrayIndexOutOfBoundsException);
        }
        try {
            array5 = Arrays.copyOfRange(array, array.length + 1, array.length + 10);
        } catch (Exception exception) {
            Assert.assertTrue(exception instanceof ArrayIndexOutOfBoundsException);
        }
        try {
            array6 = Arrays.copyOfRange(array, 6, 5);
        } catch (Exception exception) {
            Assert.assertTrue(exception instanceof IllegalArgumentException);
        }

        int[] nullArray = null;
        try {
            array7 = Arrays.copyOfRange(nullArray, 1, 3);
        } catch (Exception exception) {
            Assert.assertTrue(exception instanceof NullPointerException);
        }

        System.out.println(array4);
        System.out.println(array5);
        System.out.println(array6);
        System.out.println(array7);

        int[] array8 = Arrays.copyOfRange(array, array.length, array.length + 3);
        print_array(array8);
    }

    private void print_array(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }
}
