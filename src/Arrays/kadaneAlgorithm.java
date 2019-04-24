package Arrays;

import java.util.HashMap;

public class kadaneAlgorithm {

    public static int maxSumInArray(int[] arr) {
        //Kadane's Algorithm
        int max = 0;
        int temp = 0;

        for (int x : arr) {
            temp = temp + x;
            temp = Math.max(temp, 0);
            max = Math.max(temp, max);
        }
        return max;
    }

    public static void main(String[] args) {
        HashMap<Integer,Integer>m=new HashMap<>();
        System.out.println(m.get(1));
    }
}
