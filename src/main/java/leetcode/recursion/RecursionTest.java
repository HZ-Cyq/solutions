package leetcode.recursion;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenyuqun
 */
public class RecursionTest {
    @Test
    public void test698() {
        int[] nums = new int[]{
                10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6
        };
        System.out.println(canPartitionKSubsets(nums, 3));
    }

    /*public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int num = sum / k;
        if (num * k != sum) {
            return false;
        }
        return findSubsets(nums, num, num);
    }

    public boolean findSubsets(int[] nums, int target, int num) {
        printArray(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                continue;
            }
            if (nums[i] == num) {
                nums[i] = -1;
                return findSubsets(nums, target, target);
            }
            if (nums[i] < num) {
                int target1 = num - nums[i];
                nums[i] = -1;
                return findSubsets(nums, target, target1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                return false;
            }
        }
        return true;
    }

    public void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
    }*/

    /**
     * @param groups
     * @param row
     * @param nums
     * @param target
     * @return
     */
    /*public boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) return true;
                groups[i] -= v;
            }
//            if (groups[i] == 0) break;
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) return false;
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }*/
    public boolean canPartitionKSubsets(int[] nums, int k) {
        /*//背包问题；所有物品都要装入背包；
        int sum=0;
        int n=nums.length;
        for(int num:nums){
            sum+=num;
        }
        sum=sum/k;//背包的容量；
        boolean[][] dp=new boolean[n+1][sum+1];             //不是
        //base case;                                         //背包问题
        dp[0][0]=true;
        //下面两个循环其实可以不写，因为默认值就为false；
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;//因为全为正整数；
        }
        for(int i=1;i<sum+1;i++){
            dp[0][i]=false;
        }
        //dp；
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){

            }
        }
        return dp[n][sum];*/
        int n = nums.length;
        boolean[] used = new boolean[n];
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        //target/=k;
        if (target % k != 0) return false;
        target /= k;
        return dfs(nums, k, 0, target, 0, used);

    }

    //private boolean dfs(int[] nums,int k,int start,int target,int cur,List<Integer> track){
    //本题无需输出路径；所以track不需要定义；
    private boolean dfs(int[] nums, int k, int start, int target, int cur, boolean[] used) {
        int n = nums.length;
        //结束路径条件；
        if (k == 0) {
            return true;
        }
        if (cur == target) {
            return dfs(nums, k - 1, 0, target, 0, used);
        }
        //可选的状态遍历；（本质是多叉树的遍历模板）；
        for (int i = start; i < n; i++) {
            if (used[i]) {//表示该节点已被遍历过，功能相当于visited;
                continue;
            }
            used[i] = true;
            //dfs(nums,k,i+1,target,cur+nums[i],used);//错误；
            if (dfs(nums, k, i + 1, target, cur + nums[i], used)) {
                return true;
            }
            used[i] = false;
        }
        return false;//意思相当于是，如果以上相关遍历都没有return true，那么只剩下false的可能了；
    }

}

