package Algorithms.UnionFind;

public class WeightedUnionFindWithPC {

    //Smaller tree is put down the root of the bigger tree to make the tree as flat as possible.
    //as a result, log(n) is the complexity of find operations and union.-->Height of th trees.

    private int[] id, sz;

    public WeightedUnionFindWithPC(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public void print() {
        for (int i : id) System.out.println(i + " ");
        //for (int x : sz) System.out.println("Size : " + x);
    }

    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (p == 7 && q == 10) {
            print();
            System.out.println("rootp+\" \"+rootq = " + rootp + " " + rootq);
        }
        
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
        while (id[x] != x) {
            x = id[id[x]];                                //--> Path Compression.
        }
        return x;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

}
