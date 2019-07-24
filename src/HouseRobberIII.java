import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * <p>
 * Input: [3,4,5,1,3,null,1]
 * <p>
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */

public class HouseRobberIII {
    public int rob(TreeNode root) {
        // 每个node都有两种选项，算或者不算
        if (root == null) return 0;
        return Math.max(robOrNot(root)[0], robOrNot(root)[1]);
    }

    public int[] robOrNot(TreeNode root) {
        if (root == null) return new int[2];
        int[] ans = new int[2];
        int[] left = robOrNot(root.left);
        int[] right = robOrNot(root.right);
        ans[0] = root.val + left[1] + right[1];
        ans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return ans;
    }
}
