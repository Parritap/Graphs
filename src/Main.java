public class Main {
    public static void main(String[] args) {
        Graph graph1 = new Graph(7);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 3);
        graph1.addEdge(0, 5);

        graph1.addEdge(1, 0);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 4);

        graph1.addEdge(2, 1);
        graph1.addEdge(2, 4);
        graph1.addEdge(2, 6);

        graph1.addEdge(3, 0);
        graph1.addEdge(3, 4);
        graph1.addEdge(3, 2);

        graph1.addEdge(4, 0);
        graph1.addEdge(4, 1);
        graph1.addEdge(4, 2);
        graph1.addEdge(4, 3);

        graph1.addEdge(5, 0);
        graph1.addEdge(6, 2);


        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(3, 2);

        g.printMatrizAdyacencia();
    }
}