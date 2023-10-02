fun main() {
    val graph = createExampleGraph()
    val x: Array<IntArray>;
}

fun getTransitiveClosure(g: Graph) {
    val m = g.matrizDeAdyacencia
    for (e in 1..g.num_nodes) {
        //Devuelve todos los indices que contengan un uno como valor asociado.
        val c = m[e].withIndex().filter { it.value == 1 }.map { it.index };
        val fila = columnToList(m,e).withIndex().filter { it.value == 1 }.map { it.index };
        //Devuelve todos los indices que contenga un uno como valor asociado en la columna dada

    }
}

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


//Obtiene una lista a partir de una columna en la posición i
fun columnToList(m: Array<IntArray>, i: Int): List<Int> = m.map { fila -> fila[i] }
