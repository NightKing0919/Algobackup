import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cf {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = readInt(readL(br));
        String[] x = readL(br).split(" ");
        int[] arr = new int[x.length];
        int prev = 0;
        int ans = 0;
        int cnt = 0;
        int seg = Integer.MAX_VALUE;
        int curs = 0;
        for (int i = 0; i < n; i++) {
            int cur = readInt(x[i]);
            if (cur == prev) {
                cnt++;
            } else {
                if (i != 0) {
                    curs = cnt;
                    seg = Math.min(seg, cnt);
                }
                prev = cur;
                cnt = 1;
            }
        }
        ans = Math.min(curs, cnt);
        ans = Math.max(seg, ans);
        System.out.println(ans * 2);

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
