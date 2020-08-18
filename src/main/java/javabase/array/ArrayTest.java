package javabase.array;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.response.OapiReportListResponse;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.sun.deploy.util.ArrayUtil;
import org.junit.Assert;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;
import java.util.List;

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

        // 如果from == to,会返回一个长度为0的数组
        int[] array9 = Arrays.copyOfRange(array, 3, 3);
        System.out.println("arrray9.length: " + array9.length);
    }

    private void print_array(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }

    @Test
    public void testInit() {
        // 初始化Json的数组，元素是null
        JSONObject[] array = new JSONObject[2];
        array[0] = new JSONObject();
        array[0].clear();
//        System.
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        JSONObject json1 = new JSONObject();
        JSONObject json2 = new JSONObject();
        json1.put("hello1", "world1");
        json2.put("hello2", "world2");

        JSONObject[] jsonArray = {json1, json2};
        int length = jsonArray.length;
        Assert.assertTrue(length == 2);
        Assert.assertEquals(jsonArray[0], json1);
        Assert.assertEquals(jsonArray[1], json2);
    }

    @Test
    public void testPara() {
        Integer[] integers = null;
        printArray(integers);
    }

    public void printArray(Integer[] integers) {
        Preconditions.checkNotNull(integers, "");
        for (Integer i : integers) {
            System.out.println(i);
        }
    }

    @Test
    public void testPrecondition() {

        Integer i = null;
//        Preconditions.checkNotNull(i, "i为Null");
        Preconditions.checkNotNull(i, "i为null,%s", "hello");
    }

    @Test
    public void test1() {
        List<String> list = null;
        for (String str : list) {
            System.out.println(str);
        }
    }

    @Test
    public void test2() {
        int[] array = {1, 2, 3};
        Assert.assertEquals(3, array.length);
    }

    @Test
    public void test3() {
        String str = "-11_2_3";
        String[] array = str.split("_");
        int a = Integer.parseInt(array[0]);
        Assert.assertEquals(a, -11);
    }

    @Test
    public void test4() {
        List<String> list = Lists.newArrayList();
        System.out.println(list.get(0));
    }
}
