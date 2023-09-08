package nowcoder.code.binary_search.rotating_array;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/6
 */
public class LeetCode81 {
    public static void main(String[] args) {

    }

    public boolean search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        // 保持搜索空间里至少有三个元素
        while (begin < end - 1) {
            int mid = begin + (end - begin) / 2;
            if(target == nums[mid]) {
                return true;
            }
            if(nums[mid] == nums[begin]) {
                begin ++;
                continue;
            }

            if(nums[mid] > nums[begin]) {
                // 落在左区间
                if(target >= nums[begin] && target < nums[mid]) {
                    end = mid;
                } else {
                    begin = mid;
                }
            } else {
                // 落在右区间
                if(target <= nums[end] && target > nums[mid]) {
                    begin = mid;
                } else {
                    end = mid;
                }
            }
        }
        // 迭代之后，搜索空间里最多有两个元素
        if(nums[begin] == target) {
            return true;
        } else if(nums[end] == target) {
            return true;
        } else {
            return false;
        }
    }
}
