import java.io.IOException;
import java.util.*;

public class Coding {

    public static void main(String[] args) throws IOException {


    }

    static int firstUniqueChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    static void reverseString(char[] s) {
        int len = s.length;
        int i = 0;
        for (i = 0; i < len / 2; i++) {
            int j = len - i - 1;
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
        }
    }

    static List<String> fizzBuzz(int n) {

        HashMap<Integer, String> map = new HashMap<>();
        List<String> lis = new ArrayList<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");
        for (int i = 1; i <= n; i++) {
            String ans = "";
            for (Integer x : map.keySet()) {
                if (i % x == 0) ans += map.get(x);
            }
            if (ans == "") {
                ans += Integer.toString(i);
            }
            lis.add(ans);

        }
        return lis;
    }

    static int removeDuplicatesSet(int[] nums) {
        int len = nums.length;
        int last = nums[len - 1];
        Set<Integer> set = new TreeSet<>();
        for (int x : nums) set.add(x);
        Iterator<Integer> it = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            nums[i] = it.next();
        }
        System.out.println(set);
        for (int xx : nums) System.out.print(xx + " ");
        System.out.println();
        return set.size();
    }

    static String longestCommonPrefix(String[] strs) {


        return "";
    }

    static int mySqrt(int x) {
        if (x <= 0) return 0;
        if (x == 1) return 1;
        int l = 0;
        int r = x;
        int mid = 0;
        int res = 0;
        while (l < r) {
            mid = (l + r) >>> 1;
            //System.out.println("l+\" \"+r = " + l+" "+r);
            if (x / mid < mid) {
                r = mid;
            } else {
                res = mid;
                l = mid + 1;
            }
        }
        return res;
    }

    static int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            res = res << 1 | n & 1;
            n = n >> 1;
        }
        return res;
    }

    static void rotate(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        k = k % len;
        for (int i = 0; count < nums.length; i++) {
            int temp = 0;
            int cur = i;
            int prev = nums[i];
            do {
                int next = (cur + k) % len;
                temp = nums[next];
                nums[next] = prev;
                prev = temp;
                count++;
                cur = next;
            } while (cur != i);
        }
    }

    static int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if ((rev == Integer.MAX_VALUE / 10 || rev == Integer.MIN_VALUE / 10) && pop > 7) {
                return 0;
            }
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            while (start <= end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start <= end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (start <= end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        System.out.println("start = " + start);
        System.out.println("end = " + end);
        return true;

    }

}
