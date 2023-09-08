package nowcoder.code.binary_search.rotating_array;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/6
 */
public class LeetCode189 {

    public static void main(String[] args) {
        LeetCode189 leetCode189 = new LeetCode189();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        leetCode189.rotate(nums, k);
        System.out.println(nums);
    }

    /**
     * 旋转
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        // 旋转
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 直接计算
     */
    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        // 被挪到正确位置的元素数量
        int count = 0;
        for (int i = 0; i < nums.length && count < nums.length; i++) {
            // 将位置i的元素挪到位置(i + k) % length上
            int j = i;
            int jVal = nums[j];
            // 一次迭代之后， j位置的元素会被放到正确的位置上
            do {
                int newJ = (j + k) % length;
                int newJval = nums[newJ];

                nums[newJ] = jVal;

                j = newJ;
                jVal = newJval;
                count ++;
            } while (j != i);
        }
    }
    /**
     * 将begin位置（包含）到end位置（包含）的元素逆转一下
     * @param nums
     * @param begin
     * @param end
     */
    public void reverse(int[] nums, int begin, int end) {
        int mid = begin + (end - begin) / 2;
        for(int i = begin; i <= mid; i ++) {
            // 将i位置的值和end + begin - i位置的值交换一下
            int temp = nums[i];
            nums[i] = nums[end - i + begin];
            nums[end - i + begin] = temp;
        }
    }
}
