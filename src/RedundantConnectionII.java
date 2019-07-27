import java.util.HashMap;

public class RedundantConnectionII {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] can1 = {-1, -1};
    int[] can2 = {-1, -1};
    int[] parent = new int[2001];
    int[] circle = new int[2];

    public int[] findRedundantDirectedConnection(int[][] edges) {
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        // 查找可能的candidate
        for (int[] edge : edges) {
            int left = edge[0];
            int right = edge[1];
            if (map.getOrDefault(right, 0) == 0) {
                map.put(right, left);
            } else {
                can1 = new int[]{map.get(right), right};
                can2 = new int[]{left, right};
                edge[1] = 0;       // 去掉后面这一edge
            }
        }


        // 看去掉了一个edge之后是否可以成立
        boolean isTree = true;
        for (int[] edge : edges) {
            int left = edge[0];
            int right = edge[1];
            if (find(left) != find(right)) {
                parent[find(left)] = find(right);
            } else {
                isTree = false;
                circle = edge;
            }
        }

        // 若tree成立，则说明去掉的candidate是对的；
        // 若不成立，且candidate为空，则说明是成环
        // 若不成立，且candidate不为空，则说明得换一个candidate

        if (isTree) return can2;
        else {
            if (can1[0] == -1) return circle;
            else return can1;
        }

    }

    public int find(int idx) {
        if (parent[idx] != idx) {
            parent[idx] = find(parent[idx]);
        }
        return parent[idx];
    }
}
