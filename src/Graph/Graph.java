package Graph;

import java.util.*;

public class Graph {

    int V;
    ArrayList<Integer>[] adjListArray;

    public Graph(int V) {
        this.V = V;
        adjListArray = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjListArray[i] = new ArrayList<>();
        }
    }

    public void addEdge(Graph graph, int src, int dest) {
        graph.adjListArray[src].add(dest);
        graph.adjListArray[dest].add(src);
    }

    public boolean isCyclicHelper(int v, boolean vis[], int parent) {
        vis[v] = true;
        Iterator<Integer> it = adjListArray[v].listIterator();

        while (it.hasNext()) {
            int i = it.next();
            if (!vis[i]) {
                if (isCyclicHelper(i, vis, v)) return true;
            } else if (i != parent) {
                return true;
            }
        }
        return false;

    }

    public boolean isCyclic() {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (isCyclicHelper(i, vis, -1))
                    return true;
            }
        }
        return false;
    }

    public void dfsHelper(int source, boolean[] vis) {


        Stack<Integer> stk = new Stack<>();
        stk.push(source);
        vis[source] = true;

        while (!stk.isEmpty()) {
            int node = stk.pop();
            System.out.print(node + " ");
            Iterator<Integer> i = adjListArray[node].listIterator();
            //System.out.println(adjListArray[node]);
            while (i.hasNext()) {
                node = i.next();
                if (!vis[node]) {
                    stk.push(node);
                    vis[node] = true;
                }
            }
        }

    }

    public void dfs() {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) dfsHelper(i, vis);
        }
    }

    public void bfs(int source) {
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;
        while (!q.isEmpty()) {
            source = q.poll();
            System.out.print(source + " ");
            Iterator<Integer> it = adjListArray[source].listIterator();
            //System.out.print(source+" "+adjListArray[source]);
            while (it.hasNext()) {
                int n = it.next();
                if (!vis[n]) {
                    vis[n] = true;
                    q.add(n);
                }
            }
        }
    }

    public void printGraph(Graph graph) {
        for (int v = 0; v < graph.V; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (Integer pCrawl : graph.adjListArray[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }
}
