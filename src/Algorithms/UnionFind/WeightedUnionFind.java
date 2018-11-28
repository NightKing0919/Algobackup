package Algorithms.UnionFind;

public class WeightedUnionFind {

    //Smaller tree is put down the root of the bigger tree to make the tree as flat as possible.
    //as a result, log(n) is the complexity of find operations and union.-->Height of th trees.

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
