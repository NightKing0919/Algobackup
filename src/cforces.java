import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cforces {
    static int m;
    static int n;
    static int[][] pair;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = readInt(temp[0]);
        m = readInt(temp[1]);
        pair = new int[m][2];

        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            pair[i][0] = readInt(temp[0]);
            pair[i][1] = readInt(temp[1]);
        }
        if (solve(pair[0][0])) System.out.println("YES");
        else if (solve(pair[0][1])) System.out.println("YES");
        else System.out.println("NO");

    }

    static boolean solve(int x) {
        boolean res = true;
        for (int i = 0; i < m; i++) {
            if (pair[i][0] != x && pair[i][1] != x) {
                res = check(x, pair[i][0]) || check(x, pair[i][1]);
                break;
            }
        }
        return res;
    }

    static boolean check(int x, int y) {
        for (int i = 0; i < m; i++) {
            if (pair[i][0] != x && pair[i][1] != x && pair[i][0] != y && pair[i][1] != y) {
                return false;
            }
        }
        return true;
    }

    static int readInt(String x) {
        return Integer.parseInt(x);
    }

}
