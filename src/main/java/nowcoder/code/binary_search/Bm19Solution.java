package nowcoder.code.binary_search;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/8/29
 */
public class Bm19Solution {
    public static void main(String[] args) {
        // 2 4 1 2 7 8 4
        int[] nums = new int[]{2, 4, 1, 2, 7, 8, 4};
        Bm19Solution bm19Solution = new Bm19Solution();
        System.out.println(bm19Solution.findPeakElement(nums));
    }

    public int findPeakElement (int[] nums) {
        if (nums == null) {
            return -1;
        }
        // write code here
        int begin = 0;
        int end = nums.length - 1;
        // index在(begin, end)之间(不是begin, 也不是end)
        while (begin < end - 1) {
            int midIndex = (begin + end) / 2;
            int left = nums[midIndex - 1];
            int right = nums[midIndex + 1];
            int mid = nums[midIndex];
            // 有四种可能
            // 1、中 高 高， 2、中 高 低， 3、中 低 高， 4、中 低 低
            // 2: mid就是峰值
            // 1: 峰值在(mid. end)之间
            // 3: 峰值在(mid, end)之间
            // 4: 峰值在(start, mid)之间
            if (mid > left && mid > right) {
                return midIndex;
            }
            if ((left < mid && mid < right) || (left > mid && mid < right)) {
                begin = midIndex;
            }
            if (left > mid && mid > right) {
                end = midIndex;
            }
        }
        return findPeek(nums, begin, end);
    }

    // start和end最多只差一个
    public int findPeek(int[] nums, int start, int end) {
        if (end - start > 1 || end - start < 0) {
            return -1;
        }
        if (end - start == 0) {
            return start;
        }
        if (end - start == 1) {
            return nums[start] < nums[end] ?  end : start;
        }
        return -1;
    }
}

