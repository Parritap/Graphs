fun main() {
   val graph = createExampleGraph()
   val adjacencyMatrix = graph.getAdjacencyMatrix()
   adjacencyMatrix.forEach { println(it.contentToString()) }
   print("------------------\n")
   val closure = getTransitiveClosure(graph)
   closure.forEach { println(it.contentToString()) }

}

/**
 * Overload of the getTransitiveClosure() method
 * @param g Directed graph
 * @return Transitive clouse matrix of the given graph.
 */
fun warshallsAlgorith (g: Graph) : Array<IntArray> {
    return getTransitiveClosure(g);
}


/**
 * Gets the transitive closure matrix for a given graph, also called the Reachability Matrix.
 * If any node i is reachable by another node j for all pair of nodes, even if j is not directly connected
 * to i, then, the [i,j] coordinate of the Reachability Matrix will be marked with a 1, else, a 0.
 *
 * @param g Directed graph.
 * @return An Int Matrix that indicates if it is possible to go from node i to node j.
 */
fun getTransitiveClosure(g: Graph) : Array<IntArray> {
    val m = g.getAdjacencyMatrix()
    for (e in 0 until g.v) {
        val row = m[e].withIndex().filter { it.value == 1 }.map { it.index };
        val column = columnToList(m,e).withIndex().filter { it.value == 1 }.map { it.index };
        crossProductOf(column,row).forEach { m[it.first][it.second] = 1 }
    }
    return m;
}

/**
 * Calculate the cross product of two lists.
 * For example if we have the lists [1,2] and [3,4] the result will be [(1,3),(1,4),(2,3),(2,4)]
 * @param row
 * @param column
 * @return An ArrayList of Pairs of Ints.
 */
fun crossProductOf(row: List<Int>, column: List<Int>): ArrayList<Pair<Int,Int>> {
    val res = ArrayList<Pair<Int,Int>>()
    row.forEach { i -> column.forEach { j -> res.add(Pair(i,j)) } }
    return res;
}

/**
 * Gets the ith column of a matrix and converts its values to a List of Ints.
 *
 * @param m Matrix
 * @param i Column index
 * @return List of Ints.
 */
fun columnToList(m: Array<IntArray>, i: Int): List<Int> = m.map { fila -> fila[i] }

/**
 * Creates example graph
 * @return A prebuilt directed graph.
 */
fun createExampleGraph(): Graph {
    val graph = Graph(4)
    graph.addEdge(1, 0)
    graph.addEdge(1, 2)
    graph.addEdge(2, 0)
    graph.addEdge(2, 3)
    graph.addEdge(3, 0)
    graph.addEdge(3, 2)
    return graph
}


