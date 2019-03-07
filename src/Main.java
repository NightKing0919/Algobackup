import DP.StringDP;

import java.util.Arrays;

public class Main {
    static int [][]dp;
    public static void main(String[] args) {
        int[]coins={2,3};
        int sum=6883338;
        dp=new int[sum+1][coins.length];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        System.out.println(coinChange(coins,sum));

    }


    static int coinChange(int []coins,int N){
        int ncoins=coins.length-1;
        return coinChange(coins,ncoins,N);
    }
    static int coinChange(int[]coins,int m,int n){
        //System.out.println("m+\" \"+n = " + m+" "+n);
        if(n==0)return 1;
        if(n<0)return 0;
        if(m<0 && n>0)return 0;
        if(dp[n][m]!=-1)return dp[n][m];
        return dp[n][m]=coinChange(coins,m,n-coins[m])+coinChange(coins,m-1,n);
    }

}