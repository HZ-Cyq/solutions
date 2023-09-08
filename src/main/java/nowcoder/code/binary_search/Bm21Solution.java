package nowcoder.code.binary_search;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/8/30
 */
public class Bm21Solution {
    public static void main(String[] args) {
        Bm21Solution bm21Solution = new Bm21Solution();
        int[] nums = new int[]{1,0,1,1,1};
        System.out.println(bm21Solution.minNumberInRotateArray2(nums));
    }

    // 中间结点和右边端点做比较
    public int minNumberInRotateArray1(int[] nums) {
        // write code here
        if(nums == null) {
            return -1;
        }
        // 目标值在[begin, end]之间
        int begin = 0;
        int end = nums.length - 1;
        // 保持搜寻空间里至少有3个数
        while (begin < end - 1) {
            int mid = begin + (end - begin) / 2;
            // 中间结点和右边端点比较
            // 中间结点 < 右边端点：最小值在中间端点的左边
            // 中间结点 > 右边端点：最小值在中间端点的右边
            // 中间结点 == 右边端点: 右边端点往往左缩一个
            if(nums[mid] < nums[end]) {
                end = mid;
            } else if(nums[mid] > nums[end]) {
                begin = mid;
            } else {
                end -= 1;
            }
        }
        return minNumberInRotateArray(nums, begin, end);
    }

    // 中间结点和左边端点做比较
    public int minNumberInRotateArray2(int[] nums) {
        if(nums == null) {
            System.out.println("nums is null");
            return -1;
        }
        int begin = 0;
        int end = nums.length - 1;
        // 搜索空间里至少有三个元素,目标值在[begin, end]中间
        while (begin < end - 1) {
            int mid = begin + (end - begin) / 2;
            // 中间结点和左边端点值做比较
            // 中间结点 > 左边端点：最小值在中间结点右边
            // 中间结点 < 左边端点：最小值在中间结点左边
            // 中间结点 == 左边端点：左边端点往右挪一位
            if(nums[mid] > nums[begin]) {
                begin = mid;
            } else if(nums[mid] < nums[begin]) {
                end = mid;
            } else {
                begin ++;
            }
        }
        return minNumberInRotateArray(nums, begin, end);
    }

    private int minNumberInRotateArray(int[] num, int begin, int end) {
        if(begin == end) {
            return num[begin];
        }
        if(begin == end - 1) {
            return Math.min(num[begin], num[end]);
        }
        System.out.println("has error, begin: " + begin + "end: " + end);
        return -1;
    }
}
