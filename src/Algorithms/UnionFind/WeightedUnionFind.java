package Algorithms.UnionFind;

public class WeightedUnionFind {

    private int[] id, sz;

    public WeightedUnionFind(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (rootp == rootq) return;
        if (sz[rootp] < sz[rootq]) {
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];
        } else {
            id[rootq] = rootp;
            sz[rootp] += sz[rootq];
        }
    }

    private int root(int x) {
        while (id[x] != x) x = id[x];
        return x;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

}