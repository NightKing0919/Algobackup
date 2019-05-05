package DP;

import java.io.IOException;
import java.util.Arrays;

public class easymatrix {
    static char[][] grid;
    static String[][] f;
    static int nn, mm;
    static boolean[][] calc;

    public static void main(String[] args) throws IOException {
       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");*/
        /*nn = Integer.parseInt(temp[0]);
        mm = Integer.parseInt(temp[1]);*/


        /*for (int i = 0; i < nn; i++) {
            grid[i] = br.readLine().split(" ");
        }*/
        char[][] x = {{'d', 'b', 'c'}, {'c', 'a', 'c'}};
        //solve(x);
        System.out.println(solve(x));

    }

    static String solve(char[][] A) {

        nn = A.length;
        mm = A[0].length;
        grid = new char[nn][mm];
        calc = new boolean[nn][mm];
        f = new String[nn][mm];
        for (int i = 0; i < nn; i++) {
            for (int j = 0; j < mm; j++) {
                grid[i][j] = A[i][j];
            }
        }
        return solve2(0, 0);

    }

    static String solve2(int i, int j) {
        if (i == nn - 1 && j == mm - 1) return "" + grid[i][j];
        if (calc[i][j]) return f[i][j];

        String ans;
        if (i == nn - 1) ans = sort(grid[i][j] + solve2(i, j + 1));
        else if (j == mm - 1) {
            ans = sort(grid[i][j] + solve2(i + 1, j));
        } else {
            ans = sort(grid[i][j] + smallest(solve2(i + 1, j), solve2(i, j + 1)));
        }
        calc[i][j] = true;
        f[i][j] = ans;
        return ans;
    }

    static String smallest(String x, String y) {
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) < y.charAt(i)) return x;
            if (x.charAt(i) > y.charAt(i)) return y;

        }
        return x;
    }

    static String sort(String str) {
        char[] x = str.toCharArray();
        Arrays.sort(x);
        return new String(x);
    }

}
