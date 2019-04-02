import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] x = {-1, 0};
        System.out.println(maxSubArray(x));
    }

    static int maxSubArray(int[] nums) {
        int curmax = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<=0){
                curmax=nums[i];
                max=Math.max(curmax,max);
            }
            else {
                curmax+=nums[i];
                max=Math.max(curmax,max);
            }
        }return max;
    }

    //  [7,8,9,0,1,2,3,4,5,6]
    static int searchRotatedArray(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = -2;
        while (lo <= hi) {
            mid = (lo + hi) >>> 1;
            if (nums[mid] == target) return mid;

            //If left subarray sorted
            if (nums[lo] <= nums[mid]) {
                //if target in left subarray
                if (nums[lo] <= target && nums[mid] >= target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            //If Right array sorted
            else {
                if (nums[mid] <= target && nums[hi] >= target) {
                    lo = mid + 1;
                } else hi = mid - 1;
            }
        }
        return -1;
    }

    static int searchInsertPosition(int[] nums, int target) {
        int len = nums.length;
        if (target > nums[len - 1]) return len;
        else if (target < nums[0]) return 0;
        int index = BinarySearchInsert(nums, target);
        return index;

    }

    static int BinarySearchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int mid = -2;
        while (l <= h) {
            mid = (l + h) >>> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                l = mid + 1;
            } else h = mid - 1;
        }
        return nums[mid] > target ? mid : mid + 1;
    }

    static int Remove(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    static int Remove2(int[] nums, int val) {
        int i = 0;
        int j = nums.length;

        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j - 1];
                j--;
            } else i++;
        }
        return j;
    }

    static List<Integer> searchRange(final List<Integer> a, int b) {
        int left = binaryLeft(a, b);
        int right = binaryRight(a, b);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(left);
        res.add(right);
        return res;
    }

    static int binaryRight(List<Integer> a, int b) {
        int low = 0;
        int high = a.size() - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a.get(mid) == b) {
                index = mid;
                low = mid + 1;
            } else if (a.get(mid) > b) high = mid - 1;
            else low = mid + 1;
        }
        return index;
    }

    static int binaryLeft(List<Integer> a, int b) {
        int low = 0;
        int high = a.size() - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a.get(mid) == b) {
                index = mid;
                high = mid - 1;
            } else if (a.get(mid) > b) high = mid - 1;
            else {
                low = mid + 1;
            }
        }
        return index;
    }
}