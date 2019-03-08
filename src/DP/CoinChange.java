package DP;

import java.util.Arrays;

public class CoinChange {
    static private long[][] dp;
    public static long coinChange(long[] c, long n) {
        int z=(int)n;
        dp = new long[z + 1][c.length];
        for(long[]x:dp) Arrays.fill(x,-1);
        int ncoins = c.length - 1;
        return coinChange(c, ncoins, n);
    }

    private static long coinChange(long[] coins, int m, long n) {
        System.out.println("m+\" \"+n = " + m+" "+n);
        if(n==0)return 1;
        if(n<0)return 0;
        if(m<0 && n>0)return 0;
        if (dp[(int) n][m] != -1) return (long) dp[(int) n][m];
        return dp[(int) n][m] = (long) (coinChange(coins, m, n - coins[m]) + coinChange(coins, m - 1, n));
    }
}
