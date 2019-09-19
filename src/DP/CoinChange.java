package DP;

import java.io.IOException;

public class CoinChange {
    static private int[][] dp;

    public static void main(String[] args) throws IOException {
        int coins[] = {1, 2, 3};
        int m = coins.length;
        int V = 4;
        System.out.println(coinchange(coins, m, V));
    }

    static int coinchange(int[] coins, int m, int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[n];

    }

    static int coinchange2(int[] coins, int m, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[n];
    }

    static int minCoint(int[] coins, int m, int V) {
        int[] table = new int[V + 1];
        for (int i = 1; i <= V; i++) table[i] = Integer.MAX_VALUE;

        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < m; j++) {
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i]) {
                        table[i] = sub_res + 1;
                    }
                }
            }
        }
        return table[V];
    }
}
