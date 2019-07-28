import java.util.HashMap;

public class SmallestSubtreeWithAllTheDeepestNodes {
    TreeNode ans = null;
    int MAX = Integer.MIN_VALUE;
    HashMap<TreeNode, Integer> map = new HashMap<>();

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        recordDepth(root, 0);
        for (Integer depth : map.values()) {
            MAX = Math.max(MAX, depth);
        }
        return findAnswer(root);

    }

    public void recordDepth(TreeNode root, int depth) {
        if (root != null) {
            map.put(root, depth);
            if (root.left != null) recordDepth(root.left, depth + 1);
            if (root.right != null) recordDepth(root.right, depth + 1);
        }
    }

    public TreeNode findAnswer(TreeNode root) {
        if (root == null || map.get(root) == MAX) {
            return root;
        }
        TreeNode left = findAnswer(root.left);
        TreeNode right = findAnswer(root.right);
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;

    }
}
