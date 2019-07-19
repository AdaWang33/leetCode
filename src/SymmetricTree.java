public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        TreeNode root2 = root;

        return compareSymmetric(root, root2);
    }

    private boolean compareSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p != null && q == null) || (p == null && q != null)) return false;
        else if (p.val == q.val && compareSymmetric(p.left, q.right) && compareSymmetric(p.right, q.left)) return true;
        else return false;
    }
}
