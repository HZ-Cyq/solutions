package javabase.array;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @Test
    public void test5() {
        int[] nums = new int[]{1, 2, 3, 1};
        int peakIndex = findPeakElement(nums);
        System.out.println(peakIndex);
    }

    public int findPeakElement(int[] nums) {
        // 不用模板了，换一种别的思路试·试
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        // 循环保持的条件是，峰值"*y在[left, right]区间
        // 经历一次循环，要么是left往右缩，要么是right往左缩
        int midIndex = 0;
        while (l < r) {
            midIndex = (l + r) / 2;
            // midIndex不可能为nums.length - 1;
            if (nums[midIndex] < nums[midIndex + 1]) {
                // nums在[midIndex, midIndex + 1] 递增：mid的右边必有峰值 => left要向右缩
                l = midIndex + 1;
            } else {
                // nums在[midIndex, midIndex + 1] 递减：mid的左侧必有峰值 => right要向左缩
                r = midIndex;
            }
            if (l == r) {
                break;
            }
        }

        if (l == r) {
            return l;
        }
        List<Integer> re = new ArrayList();
        return -1;
    }

    /**
     * 测试打印全排列
     */
    @Test
    public void testPrintPermutation() {
        List<List<Integer>> lists = Lists.newArrayList();
        List<Integer> list1 = IntStream.range(0, 5).boxed().collect(Collectors.toList());
        List<Integer> list2 = IntStream.range(0, 6).boxed().collect(Collectors.toList());
        List<Integer> list3 = IntStream.range(0, 7).boxed().collect(Collectors.toList());
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        List<List<Integer>> fullPermutation = Lists.newArrayList();
        fullPermutation = getFull(lists,2);
        /*int j = 0;
        for (int i = 0; i < list1.size(); i++) {
            for (int i1 = 0; i1 < list2.size(); i1++) {
                for (int i2 = 0; i2 < list3.size(); i2++) {
                    List<Integer> list = Lists.newArrayList();
                    list.add(lists.get(j).get(i));
                    list.add(lists.get(j + 1).get(i1));
                    list.add(lists.get(j + 2).get(i2));
                    fullPermutation.add(list);
                }
            }
        }*/

        fullPermutation.forEach(list -> {
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i));
            }
            System.out.println(list.get(list.size() - 1));
        });
    }

    public List<List<Integer>> getFull(List<List<Integer>> lists, int m) {
        if (m == 0) {
            List<List<Integer>> full = Lists.newArrayList();
            for (int i = 0; i < lists.get(m).size(); i++) {
                List<Integer> list = Lists.newArrayList();
                list.add(lists.get(m).get(i));
                full.add(list);
            }
            return full;
        }
        List<List<Integer>> list = getFull(lists, m - 1);
        List<List<Integer>> re = Lists.newArrayList();
        for (List<Integer> integers : list) {
            List<List<Integer>> re1 = Lists.newArrayList();
            for (int i = 0; i < lists.get(m).size(); i++) {
                List<Integer> l = new ArrayList<>(integers);
                l.add(lists.get(m).get(i));
                re1.add(l);
            }
            re.addAll(re1);
        }
        return re;
    }

    @Test
    public void testTwoDimension() {
        int[][] intArray = new int[10][20];
        System.out.println(intArray.length);
        System.out.println(intArray[0].length);
    }
}
