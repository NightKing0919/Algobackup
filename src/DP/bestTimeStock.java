package DP;

public class bestTimeStock {

    public static void main(String[] args) {
        int[] a = {7, 6, 4, 3, 1};
        System.out.println(maxProfit5(a));
    }


    static int maxProfit5(int[] prices) {
        return maxProfitHelperBest(prices, 2);
    }

    static int maxProfitHelperBest(int[] prices, int k) { //O(n*k)
        int[][] dp = new int[k + 1][prices.length];

        if (k >= prices.length / 2) {
            int max = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i] < prices[i + 1]) {
                    max += prices[i + 1] - prices[i];
                }
            }
            return max;
        }
        for (int i = 1; i < dp.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(maxDiff + prices[j], dp[i][j - 1]);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];

    }

    static int maxProfitHelper(int[] prices, int k) { //O(n*n*k)
        int[][] dp = new int[k + 1][prices.length];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int maxVal = 0;
                for (int m = 0; m < j; m++) {
                    maxVal = Math.max(maxVal, prices[j] - prices[m] + dp[i - 1][m]);
                }
                dp[i][j] = Math.max(maxVal, dp[i][j - 1]);
            }
        }
        return dp[k][prices.length - 1];

    }

    static int maxProfit4(int[] prices) {
        if (prices.length == 0) return 0;
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    static int maxProfit3(int[] prices) {
        int i = 0;
        int peak = prices[0];
        int min = prices[0];
        int max = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
            min = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
            peak = prices[i];
            max += peak - min;
        }
        return max;
    }

    static int maxProfit2(int[] prices) {
        return calculate(prices, 0);
    }

    static int calculate(int[] prices, int n) {
        if (n >= prices.length) return 0;
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            int local = 0;
            for (int j = i + 1; j < prices.length; i++) {
                if (prices[j] > prices[i]) {
                    int profit = calculate(prices, j + 1) + prices[j] - prices[i];
                    if (profit > local) local = profit;
                }
            }
            max = Math.max(local, max);
        }
        return max;
    }

    static int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < min) min = prices[i];
            else if (prices[i] - min > maxprofit) {
                maxprofit = prices[i] - maxprofit;
            }
        }
        return maxprofit;

    }

}
