import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * Return:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        ArrayDeque<Integer> level = new ArrayDeque<>();

        pathSum(root, sum, 0, level, ans);
        return ans;
    }

    public void pathSum(TreeNode root, int sum, int addUp, ArrayDeque<Integer> level, List<List<Integer>> ans) {
        addUp += root.val;
        level.addLast(root.val);

        if (root.left == null && root.right == null && addUp == sum){
            ans.add(new ArrayList<>(level));
        }
        if (root.left != null) {
            pathSum(root.left, sum, addUp, level, ans);
        }
        if (root.right != null) {
            pathSum(root.right, sum, addUp, level, ans);
        }
        level.removeLast();

    }
}
