/**
 * int sum = 0;
 * <p>
 * public int rangeSumBST(TreeNode root, int L, int R) {
 * addUp(root, L, R);
 * return sum;
 * }
 * <p>
 * public void addUp(TreeNode root, int L, int R) {
 * if (root == null) return;
 * addUp(root.left, L, R);
 * if (root.val >= L && root.val <= R) sum += root.val;
 * addUp(root.right, L, R);
 * }
 */

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        // 要利用BST可以跳来跳去的特性，不要用BT的普适做法(in-order traversal)
        if (root == null) return 0;
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        } else {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
    }
}
