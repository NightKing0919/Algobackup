import java.util.Arrays;

public class Outer {
    final static long mod = 1000000007;
    static long[] dp;

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 2, 4};
        int[] y = {2, 6};
        int[] xx = {2, 10, 5, 4, 8};
        int[] yy = {3, 1, 7, 8};
        int[] ans = counts(xx, yy);
        for (int b : ans) System.out.print(b + " ");
        System.out.println();

    }

    static int[] counts(int[] nums, int[] maxes) {
        Arrays.sort(nums);
        //Arrays.sort(maxes);
        int[] ans = new int[maxes.length];
        for (int i = 0; i < maxes.length; i++) {
            ans[i] = binary(nums, maxes[i], 0);
        }
        /*for(int i=0;i<ans.length;i++) System.out.print(ans[i]+" ");
        System.out.println();*/
        return ans;
    }

    static int binary(int[] nums, int n, int lo) {//1,2,4,4
        if (nums[nums.length - 1] <= n) return nums.length;
        //int lo = 0;
        int hi = nums.length - 1;
        int mid = (lo + hi) >>> 1;
        while (lo < hi) {
            /*System.out.println(lo+" "+hi);*/
            mid = (lo + hi) >>> 1;
            /*System.out.println("mid = " + mid);*/
            if (nums[mid] <= n) {
                if (nums[mid + 1] > n) return mid + 1;
                else lo = mid;
            } else if (nums[mid] > n) {
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return 0;
    }


    static int superDigit(String n, int k) {
        long sum = 0;
        for (int i = 0; i < n.length(); i++) sum += Long.parseLong(n.charAt(i) + "");
        System.out.println(sum);
        sum = sum * k;
        String x = String.valueOf(sum);
        return rec(x);
    }

    static int rec(String n) {
        if (n.length() == 1) return Integer.parseInt(n.charAt(0) + "");
        int sum = 0;
        for (int i = 0; i < n.length(); i++) sum += Integer.parseInt(n.charAt(i) + "");
        String x = String.valueOf(sum);
        return rec(x);
    }

    static long stairCases(int n, int tot) {
        if (n == tot) return 1;
        if (n > tot) return 0;
        if (dp[n] != -1) return dp[n];
        return dp[n] = (stairCases(n + 1, tot) + stairCases(n + 2, tot) +
                stairCases(n + 3, tot));
    }

    static int fib(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;
        return fib(n - 1) + fib(n - 2);
    }

}


