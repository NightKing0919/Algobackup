import java.util.Arrays;

public class Main {
    static long[][] dp;
    public static void main(String[] args) {
        long[] coins = {2, 3};
        int sum = 10;
        dp = new long[sum + 1][coins.length];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        System.out.println(coinChange(coins,sum));

    }


    static long coinChange(long[] c, long n) {
        int ncoins = c.length - 1;
        return coinChange(c, ncoins, n);
    }

    private static long coinChange(long[] coins, int m, long n) {
        //System.out.println("m+\" \"+n = " + m+" "+n);
        if(n==0)return 1;
        if(n<0)return 0;
        if(m<0 && n>0)return 0;
        if (dp[(int) n][m] != -1) return (long) dp[(int) n][m];
        return dp[(int) n][m] = (long) (coinChange(coins, m, n - coins[m]) + coinChange(coins, m - 1, n));
    }

}