/**
 * if (root == null) return true;
 * int left = root.left != null ? root.left.val : root.val;
 * int right = root.right != null ? root.right.val : root.val;
 * return (root.val == left) && (root.val == right) && isUnivalTree(root.left) && isUnivalTree(root.right);
 */

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return isUnival(root, new int[]{root.val});
    }

    public boolean isUnival(TreeNode root, int[] val) {
        if (root == null) return true;
        return root.val == val[0] && isUnival(root.left, val) && isUnival(root.right, val);
    }
}

