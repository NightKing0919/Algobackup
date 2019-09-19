package DP;

public class LIS {

    public static void main(String[] args) {
        int[] x = {4, 10, 4, 3, 8, 9};
        System.out.println(LIS(x));
    }

    static int LIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    temp = Math.max(temp, dp[j]);
            }
            dp[i] = temp + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

   /* static int lis2(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    temp=Math.max(dp[j],temp);
                }
            }
        }
    }*/


/*  Recursive exponential solution
    static int LIS(int[] nums) {
        return LISHelper(nums, Integer.MIN_VALUE, 0);
    }

    static int LISHelper(int[] nums, int prev, int cur) {
        if (cur == nums.length) return 0;
        int k=0;
        if(nums[cur]>prev){
            k=1+LISHelper(nums,nums[cur],cur+1);
        }
        int not=LISHelper(nums,prev,cur+1);
        return Math.max(k,not);
    }
*/
    //Memoized Recursion--> O(nn^2) space and time
  /*  static int LIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length];
        for (int[] x : dp) Arrays.fill(x, -1);
        return LISHelper(nums, -1, 0, dp);
    }

    static int LISHelper(int[] nums, int prev, int pos, int[][] dp) {
        if (pos == nums.length) return 0;
        if (dp[prev + 1][pos] != -1) {
            return dp[prev + 1][pos];
        }
        int k = 0;
        if (prev < 0 || nums[prev] < nums[pos]) {
            k = 1 + LISHelper(nums, pos, pos + 1, dp);
        }
        int not = LISHelper(nums, prev, pos + 1, dp);
        return dp[prev + 1][pos] = Math.max(not, k);
    }*/

}
