import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        // graph coloring problem: neighbors can't share the same color
        // in this question, only two colors allowed, so boolean tyoe is enough
        // use BFS to traverse the graph

        boolean[] visited = new boolean[graph.length];
        boolean[] colored = new boolean[graph.length];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] || graph[i].length == 0) {
                queue.add(i);
                visited[i] = true;
                colored[i] = true;
            }
            while (!queue.isEmpty()) {
                int curVertex = queue.peek();
                queue.poll();
                int[] neighbors = graph[curVertex];
                for (int n : neighbors) {
                    if (!visited[n]) {
                        queue.add(n);
                        visited[n] = true;
                        colored[n] = !colored[curVertex];
                    } else if (colored[n] == colored[curVertex]) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
