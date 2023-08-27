public class Main {
    public static void main(String[] args) {
        Graph graph1 = new Graph(7);
        graph1.addEdge(1,2);
        graph1.addEdge(1,4);
        graph1.addEdge(1,6);

        graph1.addEdge(2,1);
        graph1.addEdge(2,3);
        graph1.addEdge(2,5);

        graph1.addEdge(3,2);
        graph1.addEdge(3,5);
        graph1.addEdge(3,7);

        graph1.addEdge(4,1);
        graph1.addEdge(4,5);
        graph1.addEdge(4,3);

        graph1.addEdge(5,1);
        graph1.addEdge(5,2);
        graph1.addEdge(5,3);
        graph1.addEdge(5,4);

        graph1.addEdge(6,1);
        graph1.addEdge(7,3);


    }
}