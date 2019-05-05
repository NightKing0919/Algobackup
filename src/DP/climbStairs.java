package DP;

public class climbStairs {
    public static void main(String[] args) {
        /*int nn = nums.length;
        int[] dp = new int[nn + 1];
        dp[0] = 0;dp[1]=nums[i];
        for (int i = 2; i <= nn; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        //return dp[nn];*/
    }

    static int climb(int n) {
        int[] memo = new int[n + 1];
        return helperClimb(0, n, memo);
    }

    private static int helperClimb(int a, int n, int[] memo) {
        if (a > n) return 0;
        if (a == n) return 1;
        if (memo[a] > 0) return memo[a];
        return memo[a] = helperClimb(a + 1, n, memo) + helperClimb(a + 2, n, memo);
    }

    static int climbDynamic(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
