package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BoxStackHeight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Box[] arr = new Box[n];
            String[] x = br.readLine().split(" ");
            for (int i = 0; i < x.length; i += 3) {
                arr[i].d = Integer.parseInt(x[i]);
                arr[i].w = Integer.parseInt(x[i + 1]);
                arr[i].h = Integer.parseInt(x[i + 2]);
            }
        }
    }

    static int maxHeight(Box[] arr, int n) {
        Box[] rot = new Box[n * 3];

        for (int i = 0; i < n; i++) {
            Box box = arr[i];
            rot[3 * i] = new Box(box.w, Math.max(box.d, box.h), Math.min(box.d, box.h));
            rot[3 * i + 1] = new Box(box.d, Math.max(box.w, box.h), Math.min(box.w, box.h));
            rot[3 * i + 2] = new Box(box.h, Math.max(box.d, box.w), Math.min(box.d, box.w));
        }
        for (int i = 0; i < rot.length; i++)
            rot[i].area = rot[i].w * rot[i].d;
        Arrays.sort(rot);
        int count = 3 * n;

        int[] msh = new int[count];
        for (int i = 0; i < count; i++) msh[i] = rot[i].h;
        for (int i = 0; i < count; i++) {
            msh[i] = 0;
            Box box = rot[i];
            int val = 0;
            for (int j = 0; j < i; j++) {
                Box prev = rot[j];
                if (box.w < prev.w && box.d < prev.d) {
                    val = Math.max(val, msh[j]);
                }
            }
        }
        return 1;


    }
}

class Box implements Comparable<Box> {
    int h;
    int d;
    int w;
    int area;

    public Box(int d, int w, int h) {
        this.d = d;
        this.w = w;
        this.h = h;
    }

    @Override
    public int compareTo(Box o) {
        return o.area - this.area;
    }
}
