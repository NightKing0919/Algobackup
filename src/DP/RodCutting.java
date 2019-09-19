package DP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RodCutting {
    static int[] sq;

    public static void main(String[] args) throws IOException {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 40};
        System.out.println(rodCut(prices, prices.length));
        System.out.println(sequence(prices.length));
    }

    static int rodCut(int[] prices, int n) {
        int[] dp = new int[n + 1];
        int len = n;
        dp[0] = 0;
        sq = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                if (prices[j - 1] + dp[i - j] > max) {
                    max = prices[j - 1] + dp[i - j];
                    sq[i] = j;
                }
            }
            dp[i] = max;
        }


        return dp[len];
    }

    static List<Integer> sequence(int n) {
        List<Integer> res = new ArrayList<>();
        while (n > 0) {
            res.add(sq[n]);
            n -= sq[n];
        }
        return res;
    }
}
