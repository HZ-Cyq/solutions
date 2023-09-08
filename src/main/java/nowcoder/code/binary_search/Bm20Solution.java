package nowcoder.code.binary_search;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/8
 */
public class Bm20Solution {
    public static void main(String[] args) throws IOException {
        Bm20Solution bm20Solution = new Bm20Solution();
        String inputPath = ".\\Bm20_input.txt";
        FileReader reader = new FileReader(inputPath);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String s = bufferedReader.readLine();
        JSONArray jsonArray = JSONObject.parseObject(s, JSONArray.class);
        int[] nums = jsonArray.stream().mapToInt(ele -> (int) ele).toArray();
        int reversePairsNum = bm20Solution.reversePairs(nums, 0, nums.length - 1);
        System.out.println(reversePairsNum);
    }


    /**
     * @param nums
     * @param begin
     * @return 返回[begin, end]里的逆序对，并且[begin, end]排好序。
     */
    public int reversePairs(int[] nums, int begin, int end) {
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
        int previousNum = reversePairs(nums, begin, mid);
        int followingNum = reversePairs(nums, mid + 1, end);

        int p = begin ;
        int q = mid + 1;
        int totalAddNum = 0;
        // 一次迭代之后，p（包括）之前的值是有序的，左边部分在q（不包括）之前的数都挪到了正确的位置
        while (p < q && q <= end) {
            // !! 这里是小于或等于
            if(nums[p] <= nums[q]) {
                p ++;
            } else {
                // 将q位置的值挪到p位置
                bringForward(nums, p, q);
                totalAddNum += (q - p);
                p++;
                q++;
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
}
