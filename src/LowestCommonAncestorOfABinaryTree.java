public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        return searchNode(root, p, q);

    }

    public TreeNode searchNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = searchNode(root.left, p, q);
        TreeNode right = searchNode(root.right, p, q);
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}
