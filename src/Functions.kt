fun main() {
   val graph = createExampleGraph()
   val adjacencyMatrix = graph.getAdjacencyMatrix()
   adjacencyMatrix.forEach { println(it.contentToString()) }
   print("------------------\n")
   val closure = getTransitiveClosure(graph)
   closure.forEach { println(it.contentToString()) }

}

fun getTransitiveClosure(g: Graph) : Array<IntArray> {
    val m = g.getAdjacencyMatrix()
    for (e in 0 until g.v) {
        val row = m[e].withIndex().filter { it.value == 1 }.map { it.index };
        val column = columnToList(m,e).withIndex().filter { it.value == 1 }.map { it.index };
        crossProductOf(column,row).forEach { m[it.first][it.second] = 1 }
    }
    return m;
}

fun crossProductOf(row: List<Int>, column: List<Int>): ArrayList<Pair<Int,Int>> {
    val res = ArrayList<Pair<Int,Int>>()
    if (!row.isEmpty() and !column.isEmpty()) row.forEach { i -> column.forEach { j -> res.add(Pair(i,j)) } }
    return res;
}

//Obtiene una lista a partir de una columna en la posición i
fun columnToList(m: Array<IntArray>, i: Int): List<Int> = m.map { fila -> fila[i] }


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
