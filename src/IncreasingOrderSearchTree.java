public class IncreasingOrderSearchTree {
    TreeNode dummy = new TreeNode(0);
    TreeNode cur = dummy;

    public TreeNode increasingBST(TreeNode root) {
        inorderTraversal(root);
        return dummy.right;
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        cur.left = null;
        cur.right = new TreeNode(root.val);
        cur = cur.right;
        inorderTraversal(root.right);
    }
}
