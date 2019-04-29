package DP;

import java.util.Arrays;
import java.util.List;

public class CoinChange {
    //static private long[][] dp;
    static long[][] dp;static boolean [][]dp2;
    static List<List<Integer>> res;

    public static void main(String[] args) {
        long[] x = {2, 3, 6, 7};
        System.out.println(getWays(7, x));
    }

    static int nStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    static long getWays(long n, long[] c) {
        int z = (int) n;
        dp = new long[z + 1][c.length];
        for (long[] x : dp) Arrays.fill(x, -1);
        return getwaysHelper(c, n, c.length - 1);

    }

    static long getwaysHelper(long[] coins, long amt, int cindex) {
        if (amt == 0) {
            return 1;
        }
        if (amt < 0) return 0;
        if (cindex < 0 && amt > 0) return 0;
        if (dp[(int) amt][cindex] != -1) return dp[(int) amt][cindex];
        return dp[(int) amt][cindex] = getwaysHelper(coins, amt - coins[cindex], cindex) +
                getwaysHelper(coins, amt, cindex - 1);

    }

    static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[n];
    }

    static boolean combinationSumHelper(int[] canditates, int target, int index,List<Integer>temp) {
        if(target==0){
            temp.add()
            return true;
        }
        if(target>0 && index<0)return false;
        if(dp2[target][index])return true;
        return dp2[target][index]=combinationSumHelper(canditates,target-canditates[index],index)
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         dp2 = new boolean[target + 1][candidates.length];
        for (boolean[] x : dp2) Arrays.fill(x, false);
        combinationSumHelper(candidates, target, candidates.length);
        return res;
    }
}
