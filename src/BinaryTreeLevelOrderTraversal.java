import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int num = deque.size();
            for (int i = 0; i < num; i++) {
                TreeNode cur = deque.remove();
                level.add(cur.val);
                if (cur.left != null) deque.add(cur.left);
                if (cur.right != null) deque.add(cur.right);
            }
            ans.add(level);
        }
        return ans;
    }
}
