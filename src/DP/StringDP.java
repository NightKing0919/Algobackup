package DP;

public class StringDP {

    public static int longestPalindromeSubstring(String s) {
        int n = s.length();
        int start = 0;
        int maxLength = 1;
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            arr[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                arr[i][i + 1] = true;
                maxLength = 2;
                start = i;
            }
        }
        for(int k=3;k<=n;k++){

            for(int i=0;i<n-k+1;i++){
                int j=i+k-1;
                if(arr[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                    arr[i][j]=true;
                    if(k>maxLength){
                        maxLength=k;
                        start=i;
                    }
                }
            }
        }

        System.out.println("Longest substring is " + s.substring(start, start + maxLength));
        return maxLength;


    }

}
