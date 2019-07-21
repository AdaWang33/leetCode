import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<List<Integer>> stk = new Stack<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int num = deque.size();
            for (int i = 0; i < num; i++) {
                TreeNode cur = deque.removeFirst();
                level.add(cur.val);
                if (cur.left != null) deque.addLast(cur.left);
                if (cur.right != null) deque.addLast(cur.right);
            }
            stk.add(level);
        }

        int size = stk.size();
        for (int i = 0; i < size; i++) {
            ans.add(stk.pop());
        }
        return ans;
    }
}
