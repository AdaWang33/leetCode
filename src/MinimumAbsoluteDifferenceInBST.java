public class MinimumAbsoluteDifferenceInBST {
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        getMin(root);
        return min;
    }

    public void getMin(TreeNode root){
        if (root == null) return;
        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;
        if (root.left != null) {
            leftMin = Math.abs(predecessor(root).val - root.val);
        }
        if (root.right != null) {
            rightMin = Math.abs(successor(root).val - root.val);
        }
        min = Math.min(min, Math.min(leftMin, rightMin));
        getMin(root.left);
        getMin(root.right);
    }

    public TreeNode predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public TreeNode successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
