package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TheGrid {
    static int res = 0, n;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] x = br.readLine().split(" ");
            int k = 0;
            for (String xx : x) arr[i][k++] = Integer.parseInt(xx);
        }
        if (arr[0][0] == 1 || arr[n - 1][n - 1] == 1 || (arr[n - 2][n - 1] == 1 && arr[n - 1][n - 2] == 1)) {
            System.out.println(0);
            return;
        }
        dfs(0, 0);
        System.out.println(res);


    }

    static void dfs(int x, int y) {
        System.out.println("x+\" \"+y = " + x + " " + y);
        vis[x][y] = true;
        for (int z = 0; z < 4; z++) {
            int xx = x + dx[z];
            int yy = y + dy[z];
            if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
                if (xx == n - 1 && yy == n - 1) {
                    res++;
                    return;
                } else if (arr[xx][yy] == 0 && !vis[xx][yy]) {
                    dfs(xx, yy);
                    vis[xx][yy] = false;
                }

            }
        }
    }
}
