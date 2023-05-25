import java.util.*;

public class DijkstraAlgorithm {

    private static final int INFINITY = Integer.MAX_VALUE;

    public static void dijkstra(int[][] graph, int source) {
        int numVertices = graph.length;
        boolean[] visited = new boolean[numVertices];
        int[] distances = new int[numVertices];
        Arrays.fill(distances, INFINITY);
        distances[source] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int minVertex = findMinVertex(distances, visited);
            visited[minVertex] = true;

            for (int j = 0; j < numVertices; j++) {
                if (graph[minVertex][j] != 0 && !visited[j] &&
                    distances[minVertex] != INFINITY &&
                    distances[minVertex] + graph[minVertex][j] < distances[j]) {
                    distances[j] = distances[minVertex] + graph[minVertex][j];
                }
            }
        }

        printDistances(distances);
    }

    private static int findMinVertex(int[] distances, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && (minVertex == -1 || distances[i] < distances[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    private static void printDistances(int[] distances) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + " \t\t " + distances[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int source = 0;
        dijkstra(graph, source);
    }
}
