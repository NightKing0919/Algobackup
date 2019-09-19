import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution {
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] x = br.readLine().split(" ");
            int m = Integer.parseInt(x[0]);
            int n = Integer.parseInt(x[1]);
            int k = Integer.parseInt(x[2]);

            char[][] arr = new char[m][n];

            for (int i = 0; i < m; i++) {
                x = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = x[j].charAt(0);
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char temp = arr[i][j];
                    for (int z = 1; z < k; z++) {

                    }
                }
            }

        }
    }
}
