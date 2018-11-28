package Algorithms.UnionFind;

public class QuickUnionUF {

    //Trees can get tall and finding root is expensive.Need to use weighted union and path compression for keeping the tree flat.
    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    private int root(int x) {
        while (id[x] != x) x = id[x];
        return x;
    }

    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        id[rootp] = rootq;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
