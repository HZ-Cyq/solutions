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
//        Bm20Solution bm20Solution = new Bm20Solution();
//        String inputPath = ".\\Bm20_input.txt";
//        FileReader reader = new FileReader(inputPath);
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        String s = bufferedReader.readLine();
//        JSONArray jsonArray = JSONObject.parseObject(s, JSONArray.class);
//        int[] nums = jsonArray.stream().mapToInt(ele -> (int) ele).toArray();
//        int reversePairsNum = bm20Solution.reversePairs(nums, 0, nums.length - 1);
        int[] nums = new int[]{1,2,1,2,1};
        Bm20Solution bm20Solution = new Bm20Solution();
        System.out.println(bm20Solution.reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }
        int[] temp = new int[nums.length];
        long re = reversePairs0(nums, 0, nums.length - 1, temp);

        System.out.println(re);
        int re1 = (int) (re % 1000000007);
        System.out.println(re1);
        return  re1;
    }

    public long reversePairs0(int[] nums, int begin, int end, int[] temp) {
        if(begin == end) {
            return 0;
        } else if(begin == end - 1) {
            if(nums[begin] <= nums[end]) {
                return 0;
            } else {
                int tempVal = nums[begin];
                nums[begin] = nums[end];
                nums[end] = tempVal;
                return 1;
            }
        }
        int mid = begin + (end - begin) / 2;
        long leftReversePairs = reversePairs0(nums, begin, mid, temp);
        long rightReversePairs = reversePairs0(nums, mid + 1, end, temp);
        int totalAddNum = 0;
        int p = begin;
        int q = mid + 1;
        int index = p;
        // 一次迭代之后，将左边或者右边的一个数复制到temp数组中
        // temp数组的[p,index)位置是有序的，如果是右边的数挪到了temp数组里，说明p后面的数都比q大，逆转数增加（mid - p + 1）个
        while (p <= mid || q <= end) {
            if(p > mid) {
                temp[index++] = nums[q];
                totalAddNum += mid - p + 1;
                q ++;
            } else if(q > end) {
                temp[index++] = nums[p];
                p ++;
            } else {
                if(nums[p] <= nums[q]){
                    temp[index++] = nums[p];
                    p ++;
                } else {
                    temp[index++] = nums[q];
                    totalAddNum += mid - p + 1;
                    q ++;
                }
            }
        }
        // 将temp数组复制到nums中
        for(int i = begin; i <= end; i++) {
            nums[i] = temp[i];
        }
        return leftReversePairs + rightReversePairs + totalAddNum % (1000000007);
    }

}
