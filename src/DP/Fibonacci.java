package DP;

public class Fibonacci {
//0,1,1,2,3,5,8
    public static long fibonacci(int n){
        int []store=new int[n+1];

        store[0]=0;store[1]=1;
        for(int i=2;i<=n;i++){
            store[i]=store[i-2]+store[i-1];
        }
        return (long)store[n];
    }
}
