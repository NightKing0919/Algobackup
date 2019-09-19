import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class misc {
    public static void main(String[] args) throws IOException {

        ArrayList<Interval> res = new ArrayList<Interval>();
        res.add(new Interval(1, 3));
        res.add(new Interval(2, 6));
        res.add(new Interval(8, 10));
        res.add(new Interval(15, 18));
        Collections.sort(res, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.s, o2.s);
            }
        });
        System.out.println(res);
    }

    static ArrayList<Integer> repeateddNumber(final List<Integer> A) {
        int n = A.size();
        ArrayList<Integer> res = new ArrayList<>();
        Collections.sort(A);
        System.out.println("A = " + A);
        long sum = A.get(0);
        Integer prev = 0;
        Integer ref = 0;
        for (int i = 1; i < n; i++) {

            if (A.get(i) == A.get(i - 1)) {
                System.out.println("\"HI\" = " + "HI");
                ref = A.get(i);
            }
            if (i > 210 && i < 215) {
                System.out.println("A.get(i)+\" \"+A.get(i-1) = " + A.get(i) + " " + A.get(i - 1));
                System.out.println("ref = " + ref);
            }
            sum += A.get(i);
        }
        System.out.println("ref = " + ref);
        int dup = ref;
        int original = 0;
        if (n % 2 == 0) {
            original = n / 2;
            original *= (n + 1);
        } else {
            original = (n + 1) / 2;
            original *= n;
        }

        if (sum < original) {
            int dif = (int) (original - sum);
            //System.out.println(dif);
            res.add(dup);
            res.add(dup + dif);
        } else {
            int dif = (int) (sum - original);
            //System.out.println(dif);
            res.add(dup);
            res.add(dup - dif);
        }
        return res;
    }

    static String readL(BufferedReader br) throws IOException {
        return br.readLine();
    }

    static int readInt(String x) {
        return Integer.parseInt(x);
    }

    static long readLong(String x) {
        return Long.parseLong(x);
    }
}

class Interval {
    int s;
    int e;

    public Interval(int s, int e) {
        this.s = s;
        this.e = e;
    }

    public String toString() {
        return this.s + " " + this.e;
    }
}