package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LargestNumber {
    public static void main(String[] args) {
        int[] a = {3, 30, 34, 5, 9};
        System.out.println(largest(a));
    }

    static String largest(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            String temp = x + "";
            int start = Integer.parseInt(temp.substring(0, 1));
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(x);
        }
        for (int i = 0; i < 9; i++) {
            if (map.containsKey(i))
                Collections.sort(map.get(i), Collections.reverseOrder());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (map.containsKey(i))
                for (Integer x : map.get(i)) {
                    sb.append(x);
                }
        }
        return sb.toString();
    }
}
