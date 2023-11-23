fun main() {
    val graph = createExampleGraph()
    val adjacencyMatrix = graph.getAdjacencyMatrix()
    adjacencyMatrix.forEach { println(it.contentToString()) }
    print("------------------\n")
    val closure = graph.getTransitiveClosure()
    closure.forEach { println(it.contentToString()) };
    print( "El grafo es hamiltoniano? ${graph.isHamiltonianGraph(graph)}")
}

/**
 * Overload of the getTransitiveClosure() method
 * @param g Directed graph
 * @return Transitive clouse matrix of the given graph.
 */
fun warshallsAlgorith(g: Graph): Array<IntArray> {
    return g.getTransitiveClosure();
}


/**
 * Creates example graph
 * @return A prebuilt directed graph.
 */
fun createExampleGraph(): Graph {
    val graph = Graph(4)
    graph.addEdge(0, 1)
    graph.addEdge(1, 2)
    graph.addEdge(2, 3)
    graph.addEdge(3, 0)
    return graph
}


