package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Knapsack {
    static int[] value;
    static int[] weight;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int max = Integer.parseInt(br.readLine());
            value = new int[n];
            weight = new int[n];
            dp = new int[n + 1][max + 1];
            for (int[] x : dp) Arrays.fill(x, -1);
            String[] x = br.readLine().split(" ");
            String[] xx = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                value[i] = Integer.parseInt(x[i]);
                weight[i] = Integer.parseInt(xx[i]);
            }
            //System.out.println(Arrays.toString(value));
            //System.out.println(Arrays.toString(weight));
            System.out.println(knapdp(max));
        }
    }

    static int knap(int x, int rem) {

        if (rem <= 0) return 0;
        if (x <= 0) return 0;
        if (dp[x][rem] != -1) return dp[x][rem];
        //System.out.println("x+\" \"+rem = " + x+" "+rem);
        int with = 0;
        if (rem - weight[x - 1] >= 0)
            with = value[x - 1] + knap(x - 1, rem - weight[x - 1]);
        int without = knap(x - 1, rem);
        return dp[x][rem] = Math.max(with, without);
    }

    static int knapdp(int max) {
        dp = new int[weight.length + 1][max + 1];
        for (int i = 0; i <= weight.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= max; i++) dp[0][i] = 0;
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= max; j++) {
                int weigh = weight[i - 1];
                if (weigh <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weigh]);
                } else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[value.length][max];
    }
}
