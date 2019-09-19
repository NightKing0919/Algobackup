package DP;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }

    static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
