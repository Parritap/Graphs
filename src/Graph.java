// Java program to count all paths from a source
// to a destination

import java.util.Iterator;
import java.util.LinkedList;

// This class represents a directed graph using
// adjacency list representation

class Graph {

    // No. of vertices
    private int num_nodes;

    // Array of lists for
    // Adjacency List
    // Representation
    private final LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    Graph(int numnodes) {
        num_nodes = numnodes;
        adj = new LinkedList[numnodes];
        for (int i = 0; i < numnodes; ++i)
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

    Integer[][] getPowerTrailMatrix() {
        Integer[][] matrix = new Integer[7][7];
        int trails = 0;
        for (int i = 1; i <= this.num_nodes; i++) {
            for (int j = 1; j <= this.num_nodes; j++) {
                trails = countPathsOf_K_trails(i, j, 3);
                matrix[i - 1][j - 1] = trails;
            }
        }

        return new Integer[2][2];
    }

    private int countPathsOf_K_trails(int s, int d, int k) {
        return countPaths_k_trails_util(s, d, k, 0, 1);
    }

    private int countPaths_k_trails_util(int u, int d, int k, int pathCount, int iterations) {
        if (u == d && iterations==k) {
            pathCount++;
            iterations = 0;
        }

        // Recur for all the vertices
        // adjacent to this vertex
        else {
            Iterator<Integer> i = adj[u].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                pathCount = countPaths_k_trails_util(n, d, pathCount, k,iterations+1);
            }
        }
        return pathCount;
    }


    // Driver Code
    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);

        int s = 0, d = 3;

        // Function call
        System.out.println(g.countPaths(s, d));
    }
}

// This code is contributed by shubhamjd.
