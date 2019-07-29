import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    Queue<TreeNode> queue = new LinkedList<>();
    List<TreeNode> visited = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        findParent(root, null);
        int dist = 0;

        queue.offer(null);
        queue.offer(target);
        visited.add(target);
        visited.add(null);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                if (dist == K) {
                    for (TreeNode node : queue) {
                        ans.add(node.val);
                    }
                    return ans;
                } else {
                    dist++;
                    queue.offer(null);
                }
            } else {
                if (!visited.contains(cur.left)) {
                    visited.add(cur.left);
                    queue.offer(cur.left);
                }
                if (!visited.contains(cur.right)) {
                    visited.add(cur.right);
                    queue.offer(cur.right);
                }
                TreeNode par = map.get(cur);
                if (!visited.contains(par)) {
                    visited.add(par);
                    queue.offer(par);
                }
            }
        }
        return ans;

    }

    public void findParent(TreeNode root, TreeNode parent) {
        if (root == null) return;
        map.put(root, parent);
        findParent(root.left, root);
        findParent(root.right, root);
    }
}
