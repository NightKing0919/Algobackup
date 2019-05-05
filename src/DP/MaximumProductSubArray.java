package DP;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int arr[] = {-2, 0, -1};
        System.out.println(MPS(arr));
    }

    static int MPS(int[] nums) {
        int tempmax = nums[0], tempmin = nums[0], max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int a = tempmax * nums[i];
            int b = tempmin * nums[i];
            tempmax = Math.max(Math.max(a, b), nums[i]);
            tempmin = Math.min(Math.min(a, b), nums[i]);
            max = Math.max(tempmax, max);
        }
        return max;
    }

    static int MaxProd(int[] nums) {
        //only if output guaranteed to be positive
        int max_so_far = 1, min_so_far = 1, res = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                max_so_far = Math.max(1, max_so_far * nums[i]);
                min_so_far = Math.min(1, min_so_far * nums[i]);
            } else if (nums[i] == 0) {
                max_so_far = 1;
                min_so_far = 1;
            } else {
                int t = max_so_far;
                max_so_far = Math.max(min_so_far * nums[i], 1);
                min_so_far = t * nums[i];
            }
            res = Math.max(max_so_far, res);
        }
        return res;
    }
}
