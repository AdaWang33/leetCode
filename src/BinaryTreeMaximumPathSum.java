/**
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output: 6
 * Example 2:
 * <p>
 * Input: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * Output: 42
 */

public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // 更新自己加两侧的最优选择，同时加入成为延伸的最优一侧, max作为全局变量实时更新
        if (root == null) return 0;
        oneSideMax(root);
        return max;
    }

    public int oneSideMax(TreeNode root) {
        if (root == null) return 0;

        int left = oneSideMax(root.left);      // 左子树的最优通道
        int right = oneSideMax(root.right);    // 右子树的最优通道
        max = Math.max(max, root.val + Math.max(0, left) + Math.max(0, right));
        return root.val + Math.max(0, Math.max(left, right));
    }

}
