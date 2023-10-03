import java.util.LinkedList

/**
 * Representación de un grafo. Sus nodos deberán ir del 0 al (v-1) necesariamente para
 * que sus métodos algoritmo funcionen, esto es, que si se instancia un grafo con v=3, sus nodos
 * serán por fuerza los siguientes {0,1,2}. Si v = 5, entonces sus nodos serán {0,1,2,3,4}
 */
class Graph(val v: Int) {
    /**
     * Arreglo de listas enlazadas que representa las aristas del gr
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
}