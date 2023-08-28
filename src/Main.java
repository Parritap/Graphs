public class Main {
    public static void main(String[] args) {
        Graph graph1 = new Graph(7);
        graph1.addEdge(0,1);
        graph1.addEdge(0,3);
        graph1.addEdge(0,5);

        graph1.addEdge(1,0);
        graph1.addEdge(1,2);
        graph1.addEdge(1,4);

        graph1.addEdge(2,1);
        graph1.addEdge(2,4);
        graph1.addEdge(2,6);

        graph1.addEdge(3,0);
        graph1.addEdge(3,4);
        graph1.addEdge(3,2);

        graph1.addEdge(4,0);
        graph1.addEdge(4,1);
        graph1.addEdge(4,2);
        graph1.addEdge(4,3);

        graph1.addEdge(5,0);
        graph1.addEdge(6,2);

        var x = graph1.countPaths(1,2);
        System.out.println(x);
    }
}