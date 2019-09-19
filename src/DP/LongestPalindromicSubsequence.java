package DP;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    static int[][] dp;

    public static void main(String[] args) {
        System.out.println(lpsBottomUp("bbbab"));
    }

    static int lps(String s) {
        dp = new int[s.length() + 1][s.length() + 1];
        for (int[] xx : dp) {
            Arrays.fill(xx, -1);
        }
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        return lpsHelper(s.toCharArray(), 0, s.length() - 1);
    }

    static int lpsHelper(char[] str, int i, int j) {
        if (i == j) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        if (i + 1 == j && str[i] == str[j]) return dp[i][j] = 2;
        if (str[i] == str[j]) {
            return dp[i][j] = lpsHelper(str, i + 1, j - 1) + 2;
        }
        return dp[i][j] = Math.max(lpsHelper(str, i, j - 1), lpsHelper(str, i + 1, j));
    }

    static int lpsBottomUp(String s) {
        int[][] store = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            store[i][i] = 1;
        }
        for (int k = 2; k <= s.length(); k++) {
            for (int i = 0; i < s.length() - k + 1; i++) {
                int j = i + k - 1;
                if (k == 2 && s.charAt(i) == s.charAt(j)) store[i][j] = 2;
                else if (s.charAt(i) == s.charAt(j)) {
                    store[i][j] = 2 + store[i + 1][j - 1];
                } else {
                    store[i][j] = Math.max(store[i][j - 1], store[i + 1][j]);
                }
            }
        }
        return store[0][s.length() - 1];
    }
}
