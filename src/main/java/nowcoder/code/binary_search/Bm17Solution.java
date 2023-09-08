package nowcoder.code.binary_search;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/8/28
 */
public class Bm17Solution {

    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;

        Bm17Solution bm17Solution = new Bm17Solution();
        System.out.println(bm17Solution.search(nums, 4));
    }
    public int search (int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = nums.length - 1;
        int mid = (begin + end) / 2;
        // 一定要注意边界条件。
        while (nums[mid] != target && begin < end) {
            if (nums[mid] < target) {
                // target在(mid, end]之间
                begin = mid + 1;
            } else {
                // target在[start, mid - 1]之间
                end = mid - 1;
            }
            mid = (begin + end) / 2;
            // System.out.println("[" + begin + ", " + end  +", "+ mid + "]");

        }
        if (nums[mid] == target) {
            return mid;
        } else {
            return -1;
        }
    }
}
