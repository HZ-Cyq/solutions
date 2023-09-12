package multiThreading.jmh.samples.mine;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/8
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class ReversePairsJmhTest {
    private int[] nums1;
    private int[] nums2;

    @Setup(Level.Iteration)
    public void setUp() throws IOException {
        String inputPath = ".\\Bm20_input.txt";
        FileReader reader = new FileReader(inputPath);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String s = bufferedReader.readLine();
        JSONArray jsonArray = JSONObject.parseObject(s, JSONArray.class);
        this.nums1 = jsonArray.stream().mapToInt(ele -> (int) ele).toArray();
        this.nums2 = jsonArray.stream().mapToInt(ele -> (int) ele).toArray();
    }


    @Benchmark
    public int reversePairs1() {
        int len = nums1.length;
        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums1[i];
        }
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    @Benchmark
    public int reversePairs2() {
        if(nums2 == null || nums2.length == 0 || nums2.length == 1) {
            return 0;
        }
        int[] temp = new int[nums2.length];
        return reversePairs2(nums2, 0, nums2.length - 1, temp);
    }

    /**
     * @param nums
     * @param begin
     * @return 返回[begin, end]里的逆序对，并且temp里[begin, end]排好序。
     */
    public int reversePairs2(int[] nums, int begin, int end, int[] temp) {
        if(begin == end) {
            return 0;
        }
        if(begin == end - 1) {
            // !! 这里是小于或等于
            if(nums[begin] <= nums[end]) {
                return 0;
            } else {
                bringForward(nums, begin, end);
                return 1;
            }
        }
        int mid = begin + (end - begin) / 2;
        int previousNum = reversePairs2(nums, begin, mid, temp);
        int followingNum = reversePairs2(nums, mid + 1, end, temp);

        int p = begin ;
        int q = mid + 1;
        int index = p;
        int totalAddNum = 0;
        // 一次迭代之后，p（包括）之前的值是有序的，左边部分在q（不包括）之前的数都挪到了正确的位置
//        while (p < q && q <= end) {
//            // !! 这里是小于或等于
//            if(nums[p] <= nums[q]) {
//                p ++;
//            } else {
//                // 将q位置的值挪到p位置
//                bringForward(nums, p, q);
//                totalAddNum += (q - p);
//                p++;
//                q++;
//            }
//        }
        // 一次迭代之后，会将p位置的值或者q位置的值复制到数组temp的index位置上。
        // 可以保证temp里index之前的数组是有序的。
        while (p <= mid || q <= end) {
            if(p > mid) {
                temp[index++] = temp[q];
                q++;
                totalAddNum += (mid - p + 1);
            } else if(q > end) {
                temp[index++] = temp[p];
                p++;
            } else {
               if(nums[p] <= nums[q]) {
                   temp[index++] = temp[p];
                   p++;
               } else {
                   temp[index++] = nums[q];
                   q++;
                   totalAddNum +=(mid - p + 1);
               }
            }
        }

        return previousNum + followingNum + totalAddNum;
    }

    /**
     * 将srcIndex位置的值挪到destIndex位置，[destIndex. srcIndex)位置的值都往后挪一位
     * @param nums
     * @param destIndex
     * @param srcIndex
     */
    public void bringForward(int nums[], int destIndex, int srcIndex) {
        int tempVal = nums[srcIndex];
        for (int i = srcIndex - 1; i >= destIndex; i--) {
            nums[i + 1] = nums[i];
        }
        nums[destIndex] = tempVal;
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) throws RunnerException {
        Options opts = new OptionsBuilder().include(ReversePairsJmhTest.class.getSimpleName()).
                forks(1).build();
        new Runner(opts).run();
    }
}
