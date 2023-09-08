package nowcoder.code.binary_search.rotating_array;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/7
 */
public class LeetCode153 {
    public static void main(String[] args) {

    }
    public int findMin(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        // 保持搜索空间至少有三个元素
        // 最小值在[begin, end]中间
        while (begin < end - 1) {
            int mid = begin + (end - begin) / 2;
            if(nums[begin] < nums[end]) {
                // 说明没有旋转
                return nums[begin];
            }
            if(nums[mid] > nums[begin]) {
                // 中间结点落在左边
                begin = mid;
            } else {
                // 中间结点落在右边
                end = mid;
            }
        }
        return Math.min(nums[begin], nums[end]);
    }
}
