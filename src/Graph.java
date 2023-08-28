// Java program to count all paths from a source
// to a destination

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

// This class represents a directed graph using
// adjacency list representation

//Pero es programar una matriz de adyacencia, y que cuando el usuario
//de los parámetros i, j diga si hay una conexión entre esos nodos o si no la hay

class Graph {

    // No. of vertices
    private int num_nodes;
    private Integer[][] matrizDeAdyacencia;

    // Array of lists for
    // Adjacency List
    // Representation
    private final LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    Graph(int numnodes) {
        num_nodes = numnodes;
        adj = new LinkedList[numnodes];
        for (int i = 0; i < numnodes; i++)
            adj[i] = new LinkedList<>();
    }

    // Method to add an edge into the graph
    void addEdge(int v, int w) {
        // Add w to v's list.
        adj[v].add(w);
    }

    // A recursive method to count
    // all paths from 'u' to 'd'.
    int countPathsUtil(int u, int d, int pathCount) {

        // If current vertex is same as
        // destination, then increment count
        if (u == d) {
            pathCount++;
        }

        // Recur for all the vertices
        // adjacent to this vertex
        else {
            Iterator<Integer> i = adj[u].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                pathCount = countPathsUtil(n, d, pathCount);
            }
        }
        return pathCount;
    }

    // Returns count of
    // paths from 's' to 'd'
    int countPaths(int s, int d) {

        // Call the recursive method
        // to count all paths
        int pathCount = 0;
        pathCount = countPathsUtil(s, d, pathCount);
        return pathCount;
    }

    public void obtenerMatrixAdayacencia() {
        var matrix = new Integer[num_nodes][num_nodes];
        for (int i = 0; i < num_nodes; i++) {
            for (int j = 0; j < num_nodes; j++) {
                if (matrix[i][j] == null && haveEdge(i, j)) matrix[i][j] = 1;
            }
        }
        for (int i = 0; i < num_nodes; i++) {
            for (int j = 0; j < num_nodes; j++) {
                if (matrix[i][j] == null) matrix[i][j] = 0;
            }
        }
        this.matrizDeAdyacencia = matrix;
    }

    public boolean haveEdge(int i, int j) {
        for (int vertex : this.adj[i]) {
            if (vertex == j) {
                return true;
            }
        }
        return false;
    }

    void printMatrizAdyacencia() {
        if (matrizDeAdyacencia == null) obtenerMatrixAdayacencia();
        for (Integer[] array : matrizDeAdyacencia) {
            System.out.println(Arrays.toString(array));
        }
    }
}

// This code is contributed by shubhamjd.
