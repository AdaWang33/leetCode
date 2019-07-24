public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //  BST是有序排列的.
        //  All of the nodes' values will be unique.
        //  p and q are different and both values will exist in the BST.
        // 所以，直接比较val大小

        if (root == null) return root;
        while (root != null) {
            if (root.val < p.val && root.val < q.val) root = root.right;
            else if (root.val > p.val && root.val > q.val) root = root.left;
            else break;
        }
        return root;
    }
}
