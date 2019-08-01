public class LowestCommonAncestorOfDeepestLeaves {
    int deepest = 0;
    TreeNode lca = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        dfs(root, 0);
        return lca;
    }

    public int dfs(TreeNode root, int depth) {
        deepest = Math.max(deepest, depth);
        if (root == null) return depth;
        int leftDeepest = dfs(root.left, depth + 1);
        int rightDeepest = dfs(root.right, depth + 1);
        if (leftDeepest == deepest && rightDeepest == deepest) {
            lca = root;
        }
        return Math.max(leftDeepest, rightDeepest);

    }
}
