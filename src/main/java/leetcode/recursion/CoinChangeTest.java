package leetcode.recursion;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenyuqun
 */
public class CoinChangeTest {

    @Test
    public void testCoinChange() {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange1(coins, 11));
    }

    /**
     * @param coins
     * @param amount
     * @return -1: 凑不出amount。
     * 0: 0种
     * 1 + min{f(coins, amount - coins[i]) && f(coins, amount - coins[i] != -1)| i = 0,1,2...coins.length - 1}
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        // 求最小值，所以初始化为正无穷
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int num = coinChange(coins, amount - coins[i]);
            if (num != -1 && num < min) {
                min = num;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min + 1;
    }

    // 最少的硬币个数
    public int coinChange1(int[] coins, int amount) {
        // dp[i] = x : 凑齐x硬币，至少需要i枚硬币,-1代表无法凑齐。
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] < 0) continue;
                if(dp[i - coins[j]]== -1) continue;
                if(dp[i - coins[j]] < min) {
                    min = dp[i - coins[j]];
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
        }
//        Arrays.stream(dp).forEach(System.out::println);
        return dp[amount];
    }
}
