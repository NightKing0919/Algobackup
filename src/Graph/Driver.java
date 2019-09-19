package Graph;

public class Driver {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(graph, 1, 0);
        graph.addEdge(graph, 3, 4);
        graph.addEdge(graph, 0, 3);
        graph.addEdge(graph, 2, 0);
        graph.addEdge(graph, 0, 2);
        //graph.addEdge(graph, 1, 2);

        Graph g = new Graph(3);
        g.addEdge(g, 0, 1);
        g.addEdge(g, 1, 2);
        g.printGraph(g);
        System.out.println(g.isCyclic());

    }
}
