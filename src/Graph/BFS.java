package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    static LinkedList<Integer> adj[] = new LinkedList[8];

    public static void main(String[] args) {
        for (int i = 0; i < adj.length; i++) adj[i] = new LinkedList<>();
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(1, 5);
        addEdge(2, 6);
        addEdge(6, 7);
        List<List<Integer>> res = bfs(0);
        int k = 0;
        while (res.contains(k)) {
            System.out.println(res.get(k));
            k++;
        }
    }

    static void addEdge(int x, int y) {
        adj[x].add(y);
    }

    static List<List<Integer>> bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        ArrayList<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[15];
        vis[s] = true;
        int k = 1;
        List<Integer> temp = new ArrayList<>();
        temp.add(s);
        res.add(0, temp);
        while (!q.isEmpty()) {
            int t = q.poll();
            temp = new ArrayList<>();//System.out.println("adj[t] = " + adj[t]);
            for (int i = 0; i < adj[t].size(); i++) {

                for (Integer x : adj[t]) {
                    if (!vis[x]) {
                        temp.add(x);
                        q.add(x);
                        vis[x] = true;
                    }
                }

            }
            if (!temp.isEmpty()) {
                res.add(k, temp);
                System.out.println(res);
                k++;
            }
        }
        return res;
    }
}
