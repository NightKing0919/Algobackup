package Graph;

import java.util.Scanner;

public class Spaceship {
    static int m = 5;
    static int[][] grid;
    static int n;
    static int max_coins;
    static int[] dx = {-1, -1, -1};
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            n = in.nextInt();
            grid = new int[n][6];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 5; j++) {
                    grid[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }
            max_coins = 0;
            dfs(n - 1, 1, -1, 0);
            dfs(n - 1, 2, -1, 0);
            dfs(n - 1, 3, -1, 0);
            System.out.println(max_coins);
        }
    }

    static void dfs(int x, int y, int bomb, int coin) {
        if (x < 0 || y < 0 || y > 4) {
            if (coin > max_coins) max_coins = coin;
            return;
        }
        if (grid[x][y] == 2) {
            if (bomb == -1) {
                bomb = x - 5 + 1;
                if (bomb < 0) bomb = 0;
            } else if (x < bomb) {
                if (coin > max_coins) max_coins = coin;
                return;
            }
        }

        for (int z = 0; z < 3; z++) {
            int xx = x + dx[z];
            int yy = y + dy[z];
            if (grid[x][y] == 1) dfs(xx, yy, bomb, coin + grid[x][y]);
            else dfs(xx, yy, bomb, coin);
        }
    }
}
