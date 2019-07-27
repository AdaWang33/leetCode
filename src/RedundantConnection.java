import java.util.ArrayList;
import java.util.List;

public class RedundantConnection {
    int[] parent = new int[2001];

    public int[] findRedundantConnection(int[][] edges) {
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        // union op for each edge
        for (int[] edge : edges) {
            int left = edge[0];
            int right = edge[1];
            if (find(left) != find(right)) {
                parent[find(left)] = find(right);
            } else {
                return edge;
            }
        }
        return new int[2];
    }

    public int find(int idx) {
        if (idx != parent[idx]) {
            parent[idx] = find(parent[idx]);
        }
        return parent[idx];
    }

}
