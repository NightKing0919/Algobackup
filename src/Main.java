import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        for (int i = 0; i < k; i++) {

        }
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