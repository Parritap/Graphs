import java.util.LinkedList

/**
 * Representación de un grafo. Sus nodos deberán ir del 0 al (v-1) necesariamente para
 * que sus métodos algoritmo funcionen, esto es, que si se instancia un grafo con v=3, sus nodos
 * serán por fuerza los siguientes {0,1,2}. Si v = 5, entonces sus nodos serán {0,1,2,3,4}
 */
class Graph(val v: Int) {
    /**
     * Arreglo de listas enlazadas que representa las aristas del grafo
     */
    var relations: Array<LinkedList<Int>>

    /**
     * El bloque init sirve para que, una vez instanciado el objeto,
     * se ejecute cierto bloque de codigo.
     */
    init {
        relations = Array(v) { LinkedList<Int>() }
    }

    /**
     * Obtiene la matriz de adyacencia.
     * NOTA: Los IntArray no pueden tener nulos, por lo cual sus elementos
     * quedarán inicializados en 0 por defecto.
     */
    fun getAdjacencyMatrix(): Array<IntArray> {
        val matrix = Array(v) { IntArray(v) }
        for (i in 0 until v) {
            for (j in 0 until v) if (haveEdge(i, j)) matrix[i][j] = 1
        }
        return matrix
    }

    /**
     * Si hay una relacion binaria entre ambos nodos i y j, devuelve verdadero, falso si no.
     */
    fun haveEdge(i: Int, j: Int): Boolean {
        for (vertex in relations[i]) {
            if (vertex == j) return true
        }
        return false
    }

    /**
     * Añade una arista entre los nodos i y j.
     */
    fun addEdge(i: Int, j: Int) = relations[i].add(j)


    /**
     * Obtiene las relaciones binarias del grafo.
     */
    fun getBinaryRelations () {
        for (i in 0 until v) {
            for (j in 0 until v) {
                if (haveEdge(i,j)) {
                    println("($i,$j)")
                }
            }
        }
    }


    /**
     * Gets the transitive closure matrix for a given graph, also called the Reachability Matrix.
     * If any node i is reachable by another node j for all pair of nodes, even if j is not directly connected
     * to i, then, the [i,j] coordinate of the Reachability Matrix will be marked with a 1, else, a 0.
     *
     * @return An Int Matrix that indicates if it is possible to go from node i to node j.
     */
    fun getTransitiveClosure() : Array<IntArray> {
        val m = this.getAdjacencyMatrix()
        for (e in 0 until this.v) {
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
    private fun crossProductOf(row: List<Int>, column: List<Int>): ArrayList<Pair<Int,Int>> {
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
    private fun columnToList(m: Array<IntArray>, i: Int): List<Int> = m.map { fila -> fila[i] }


    fun isHamiltonianGraph(graph: Graph): Boolean {
        val visited = BooleanArray(graph.v) { false }

        fun isHamiltonianUtil(pos: Int, path: MutableList<Int>): Boolean {
            if (pos == graph.v) {
                // Check if the last node is connected to the first node
                return graph.haveEdge(path[pos - 1], path[0])
            }

            for (v in 0 until graph.v) {
                if (!visited[v] && graph.haveEdge(path[pos - 1], v)) {
                    visited[v] = true
                    path.add(v)

                    if (isHamiltonianUtil(pos + 1, path)) {
                        return true
                    }

                    // Backtrack
                    visited[v] = false
                    path.removeAt(path.size - 1)
                }
            }

            return false
        }

        // Check for Hamiltonian cycle starting from each node
        for (startNode in 0 until graph.v) {
            val path = mutableListOf<Int>()
            path.add(startNode)
            visited[startNode] = true

            if (isHamiltonianUtil(1, path)) {
                return true
            }

            // Reset for the next iteration
            visited.fill(false)
        }

        return false
    }


}