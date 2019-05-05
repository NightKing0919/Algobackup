package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class priorities {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int p1 = 0, p2 = 0, p3 = 0, p4 = 0;

            for (int i = 0; i < n; i++) {
                str = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    if (i < n / 2) {
                        if (j < m / 2)
                            p1 += read(str[j]);
                        else p2 += read(str[j]);
                    } else {
                        if (j >= m / 2) {
                            p3 += read(str[j]);
                        } else p4 += read(str[j]);
                    }
                }
            }
            System.out.println("p1+\" \"+p2+\" \"+p3+\" \"+p4 = " + p1 + " " + p2 + " " + p3 + " " + p4);
            HashMap<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            if (p1 < 0) {
                list.add(p1);
                map.put(1, p1);
            }
            if (p2 < 0) {
                list.add(p2);
                map.put(2, p2);
            }
            if (p3 < 0) {
                list.add(p3);
                map.put(3, p3);
            }
            if (p4 < 0) {
                list.add(p4);
                map.put(4, p4);
            }
            int min = Integer.MAX_VALUE;
            for (Integer x : list) min = Math.min(x, min);

        }
    }

    static int read(String x) {
        return Integer.parseInt(x);
    }
}
