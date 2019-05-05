package DP;

import java.util.ArrayList;
import java.util.TreeSet;

public class MinPathSum {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static boolean[][] vis;
    static int[][] temp;
    static int m, n;
    static TreeSet set = new TreeSet();

    public static void main(String[] args) {
        int[][] x = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(miniPathSumDP(x));
    }

    static int miniPathSumDP(int[][] grid) {

        //SO MUCH FASTER
        //build the table by using min(prev steps)+ current cost. return final val.
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) dp[0][i] = dp[0][i - 1] + grid[0][i];
        for (int i = 1; i < grid.length; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    static int p(ArrayList<ArrayList<Integer>> A) {
        int w = A.size();
        int e = A.get(0).size();
        int[][] bb = new int[w][e];
        int g = 0;
        for (int i = 0; i < A.size(); i++) bb[i] = A.get(i).stream().mapToInt(Integer::intValue).toArray();
        return MPS(bb);
    }

    static int MPS(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        temp = grid;
        dfs(0, 0, temp[0][0]);
        if (set.size() == 0) return 0;
        return (Integer) set.first();
    }

    static void dfs(int x, int y, int carry) {
        vis[x][y] = true;

        for (int z = 0; z < 4; z++) {
            int xx = x + dx[z];
            int yy = y + dy[z];
            if (xx >= 0 && yy >= 0 && xx < m && yy < n) {
                if (xx == m - 1 && yy == n - 1) {
                    set.add(carry + temp[x][y]);
                    return;
                } else if (!vis[xx][yy]) {
                    dfs(xx, yy, carry + temp[x][y]);
                    vis[xx][yy] = false;
                }
            }
        }
    }
}
