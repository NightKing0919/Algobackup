package Graph;

import java.io.IOException;

public class ShortestReachInAGraph {

    public static void main(String[] args) throws IOException {
        Nod head = new Nod(0, new Nod(1, new Nod(0, new Nod(0, new Nod(1, new Nod(1, null))))));
        System.out.println(get(head));
    }

    static long get(Nod binary) {
        StringBuilder sb = new StringBuilder();
        while (binary != null) {
            sb.append(binary.data + "");
            binary = binary.next;
        }
        String x = sb.toString();
        //long xx=Long.parseLong(x);
        int k = 0;
        long res = 0;
        for (int i = x.length() - 1; i >= 0; i--) {
            int temp = Character.getNumericValue(x.charAt(i));
            System.out.println(temp + " " + k);
            res += (temp) * Math.pow(2, k);
            k++;
        }
        return res;
    }

    static class Nod {
        int data;
        Nod next;

        public Nod(int data, Nod next) {
            this.data = data;
            this.next = next;
        }
    }
}

