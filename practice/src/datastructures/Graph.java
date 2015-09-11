
package datastructures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Task: create an undirected graph, then add depth first and breadth first searches for it.
 * The graph node indexing starts from 1.
 * @author kipsu
 */
public class Graph {
    private final int[][] vertices;
    private final int n;

    public Graph(int nodeCount) {
        n = nodeCount + 1;
        vertices = new int[n][n];
    }
    
    public Graph addVertice(int from, int to) {
        vertices[from][to] = 1;
        vertices[to][from] = 1;
        return this;
    }
    
    public int depthFirst(int from, int target) {
        boolean[] visited = new boolean[n];
        visited[from] = true;
        int distance = depthFirst(from, target, 1, visited);
        if (distance > 0) {
            return distance;
        }
        return -1;
    }
    
    private int depthFirst(int from, int target, int travelled, boolean[] visited) {
        for (int i = 1; i < n; i++) {
            if (vertices[from][i] == 1 && !visited[i]) {
                if (i == target) {
                    return travelled;
                }
                visited[i] = true;
                int distance = depthFirst(i, target, travelled + 1, visited);
                if (distance > 0) {
                    return distance;
                }
            }
        }
        return -1;
    }
    
    public int breadthFirst(int from, int target) {
        Queue<Integer> nodesToVisit = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] distances = new int[n];
        nodesToVisit.add(from);
        while (!nodesToVisit.isEmpty()) {
            int visit = nodesToVisit.poll();
            if (visited[visit]) {
                continue;
            }
            visited[visit] = true;
            for (int i = 0; i < n; i++) {
                if (vertices[visit][i] > 0 && distances[i] == 0) {
                    distances[i] = distances[visit] + vertices[visit][i];
                    if (i == target) {
                        return distances[i];
                    }
                    nodesToVisit.add(i);
                }
            }
        }
        return -1;
    }
    
    // Test it
    public static void main(String[] args) {
        Graph graph = new Graph(8)
                .addVertice(2, 3)
                .addVertice(1, 2)
                .addVertice(3, 4)
                .addVertice(3, 6)
                .addVertice(1, 4)
                .addVertice(6, 8)
                .addVertice(2, 7)
                .addVertice(5, 1);
        
        System.out.println("some way from 1 to 4: " + graph.depthFirst(1, 4));
        System.out.println("some way from 6 to 4: " + graph.depthFirst(6, 4));
        System.out.println("some way from 7 to 8: " + graph.depthFirst(7, 8));
        System.out.println();
        System.out.println("Shortest way from 1 to 4: " + graph.breadthFirst(1, 4));
        System.out.println("Shortest way from 6 to 4: " + graph.breadthFirst(6, 4));
        System.out.println("Shortest way from 7 to 8: " + graph.breadthFirst(7, 8));
    }
}
