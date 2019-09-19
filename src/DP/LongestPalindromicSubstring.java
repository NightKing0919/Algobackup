package DP;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcba"));
    }

    static String longestPalindrome(String s) {
        int n = s.length();
        int maxL = 0;
        int start = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            maxL = 1;
            start = i;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                maxL = 2;
                start = i;
                dp[i][i + 1] = true;

            }
        }
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (maxL < k) maxL = k;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxL);

    }
}
