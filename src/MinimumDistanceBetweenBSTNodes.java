public class MinimumDistanceBetweenBSTNodes {
    int prev = Integer.MAX_VALUE;
    int MIN = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        findClosestGreater(root);
        return MIN;
    }

    public void findClosestGreater(TreeNode root) {
        if (root == null) return;
        findClosestGreater(root.left);
        if (prev != Integer.MAX_VALUE) {
            MIN = Math.min(MIN, root.val - prev);
        }
        prev = root.val;
        findClosestGreater(root.right);
    }
}

/**
 * public int minDiffInBST(TreeNode root) {
 * int[] MIN = {Integer.MAX_VALUE};
 * findMin(root, MIN);
 * return MIN[0];
 * }
 * <p>
 * <p>
 * public void findMin(TreeNode root, int[] MIN) {
 * int left = Integer.MAX_VALUE;
 * int right = Integer.MAX_VALUE;
 * if (root.left != null) {
 * findMin(root.left, MIN);
 * left = predecessor(root).val;
 * System.out.println(left);
 * }
 * if (root.right != null) {
 * findMin(root.right, MIN);
 * right = successor(root).val;
 * }
 * MIN[0] = Math.min(MIN[0], Math.min(Math.abs(root.val - left), Math.abs(root.val - right)));
 * }
 * <p>
 * public TreeNode predecessor(TreeNode root) {
 * TreeNode cur = root.left;
 * while (cur.right != null) cur = cur.right;
 * return cur;
 * }
 * <p>
 * public TreeNode successor(TreeNode root) {
 * TreeNode cur = root.right;
 * while (cur.left != null) cur = cur.left;
 * return cur;
 * }
 */
