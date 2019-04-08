import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] x = {1,2,0,1};
        System.out.println(longestConsecutive(x));
    }

    static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0)return 0;
        int max=1;int cur=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1 || nums[i]==nums[i-1]){
                cur++;max=Math.max(max,cur);
                System.out.println("cur = " + cur);
            }
            else cur=1;
        }
        return max;
    }

    static int missingNumberUsingXOR(int[] nums) { //----FASTEST O(1) space and O(n) time
        int x = nums.length;
        for (int i = 0; i < nums.length; i++) {
            x ^= i ^ nums[i];
        }
        return x;
    }

    static int missingNumberUsingSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) return i;
        }
        return -1;
    }

    static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        //System.out.println();
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) >>> 1;
            int ele = nums[mid];
            if (lo == hi && lo == 0 && nums[lo] == lo) {
                return 1;
            }
            if (lo == hi && lo == nums.length - 1 && nums[lo] == lo) return lo + 1;
            if (lo == hi && nums[lo] == lo) return lo + 1;
            if (ele == mid) {
                lo = mid + 1;
            } else if (ele != mid && ele > mid) {
                hi = mid - 1;
            }
            //else if(ele!=mid && ele)
        }
        return mid;
    }

    static List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; ) {
            int m = nums[i] ^ nums[i + 1];
            if (m == 0) {
                res.add(nums[i]);
                i += 2;
            } else i++;
        }
        return res;
    }

    static int majorityElement(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int ele = -1;
        for (int x : nums) {
            if (map.get(x) == null) {
                map.put(x, 1);
                if (max == 0) {
                    max = 1;
                    ele = x;
                }
            } else {
                int num = map.get(x) + 1;
                map.put(x, num);
                if (num > max) {
                    ele = x;
                    max = num;
                }
            }
        }
        return ele;
    }

    static int[] intersection(int[] nums1, int[] nums2) {
        //int len1 = nums1.length;
        //int len2 = nums2.length;

        HashSet<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int x : nums1) set1.add(x);
        int i = 0;
        for (int x : nums2) {
            if (set1.contains(x)) set2.add(x);
        }
        int[] res = new int[set2.size()];

        for (int n : set2) res[i++] = n;
        return res;
    }

    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();

        dollar:
        for (int i = 0; i < len - 1; i++) {
            int l = i + 1;
            int r = len - 1;
            int x = nums[i];
            while (l < r) {
                int sum = x + nums[l] + nums[r];
                if (set.contains(x) && set.contains(nums[l]) && set.contains(nums[r])) {
                    l++;
                    r--;
                    continue;
                }
                if (sum == 0) {
                    set.add(x);
                    set.add(nums[l]);
                    set.add(nums[r]);
                    List<Integer> temp = new ArrayList<>();
                    temp.add(x);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    //if(!result.contains(temp))
                    result.add(temp);

                    temp = null;
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else l++;
            }
        }
        return result;
    }

    static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null && map.get(target - nums[i]) != null && map.get(target - nums[i]) != i)
                return new int[]{i, map.get(target - nums[i])};
        }
        return new int[]{};
    }

    //Generates pascal triangle upto n levels.
    static List<List<Integer>> generatePascalTriange(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(temp);
        for (int i = 2; i <= n; i++) {
            try {
                temp = res.get(i - 2);
            } catch (Exception e) {
                System.out.println("i = " + i);
            }
            List<Integer> x = new ArrayList<>();
            x.add(1);

            for (int j = 0; j < temp.size() - 1; j++) {
                x.add(temp.get(j) + temp.get(j + 1));
            }
            x.add(1);
            res.add(x);
        }
        return res;
    }

    static void SetMatrix(int[][] matrix) {
        HashSet<Integer> setrow = new HashSet<>();
        HashSet<Integer> setcol = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int ele = matrix[i][j];
                if (ele == 0) {
                    setrow.add(i);
                    setcol.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (setrow.contains(i) || setcol.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    static int maxSubArray(int[] nums) {
        int curmax = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= 0) {
                curmax = nums[i];
                max = Math.max(curmax, max);
            } else {
                curmax += nums[i];
                max = Math.max(curmax, max);
            }
        }
        return max;
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