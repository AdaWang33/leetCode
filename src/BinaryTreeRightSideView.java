import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        // 先level-order一下，然后存入level的最后一个值
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            // List<Integer> level = new ArrayList<>();
            int last = 0;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.removeFirst();
                if (i == size - 1) last = cur.val;
                // level.add(cur.val);
                if (cur.left != null) deque.addLast(cur.left);
                if (cur.right != null) deque.addLast(cur.right);
            }
            ans.add(last);
        }
        return ans;
    }
}
