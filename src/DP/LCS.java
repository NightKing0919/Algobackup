package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] k = br.readLine().split(" ");
            String a = br.readLine();
            String b = br.readLine();
            System.out.println(lcsdp(a, b));
        }
    }

    static int lcs(String x, String y, int m, int n) {
        if (m < 0 || n < 0) return 0;
        if (dp[m][n] != -1) return dp[m][n];
        if (x.charAt(m) == y.charAt(n)) return dp[m][n] = 1 + lcs(x, y, m - 1, n - 1);
        else return dp[m][n] = Math.max(lcs(x, y, m - 1, n), lcs(x, y, m, n - 1));
    }

    static int lcsdp(String x, String y) {
        int m = x.length();
        int n = y.length();
        String[][] res = new String[m + 1][n + 1];
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
            res[i][0] = "0";
        }
        for (int i = 0; i <= n; i++) {
            res[0][i] = "0";
            dp[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res[i][j] = "diag";
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (dp[i][j] == dp[i - 1][j]) res[i][j] = "top";
                    else res[i][j] = "left";
                }
            }
        }
        return dp[m][n];
    }
}
