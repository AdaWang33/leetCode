public class DistributeCoinsInBinaryTree {
    int ans = 0;

    public int distributeCoins(TreeNode root) {
        // 规划类从底层leaf着手考虑，和camera的题目要放在一起看
        numToParent(root);
        return ans;
    }

    public int numToParent(TreeNode root) {
        if (root == null) return 0;
        int left = numToParent(root.left);
        int right = numToParent(root.right);
        ans += Math.abs(left) + Math.abs(right);
        return left + right + root.val - 1;
    }
}
