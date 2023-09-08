package nowcoder.code.binary_search.rotating_array;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/6
 */
public class LeetCode33 {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int begin = 0;
        int end = nums.length - 1;
        // target在[begin, end]之间
        // 保持搜索空间里至少有三个元素
        while (begin < end - 1) {
            int mid = begin + (end - begin) / 2;
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] > nums[begin]) {
                // mid落在左边
                if(target >= nums[begin] && target < nums[mid]) {
                    end = mid;
                } else {
                    begin = mid;
                }
            } else if(nums[mid] < nums[begin]) {
                // mid落在右边
                if(target > nums[mid] && target <= nums[end]) {
                    begin = mid;
                } else {
                    end = mid;
                }
            }
        }
        return findTarget(nums, begin, end, target);

    }

    /**
     * begin和end相等或者end = begin + 1;
     * @param nums
     * @param begin
     * @param end
     * @param target
     * @return
     */
    public int findTarget(int[] nums, int begin, int end, int target) {
        if(begin == end) {
            return nums[begin] == target ? begin : -1;
        } else if (begin == end - 1){
            if(nums[begin] == target) {
                return begin;
            }
            if(nums[end] == target) {
                return end;
            }
            return -1;
        } else {
            return -1;
        }
    }
}
