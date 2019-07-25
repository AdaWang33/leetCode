public class DiameterOfBinaryTree {
    // for each node, the longest subtree of itself is maxDepth of left tree + maxDepth of right tree
    int maxDepth = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        findDepth(root);
        return maxDepth;
    }

    public int findDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);

        maxDepth = Math.max(maxDepth, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
