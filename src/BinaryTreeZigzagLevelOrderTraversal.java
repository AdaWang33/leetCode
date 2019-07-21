import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 先尝试一下用deque模拟stack和queue，达到zigzag traversal的效果
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        boolean sign = true; // whether it's queue, true for queue and false for stack
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur;
                cur = deque.removeFirst();
                level.add(cur.val);
                if (cur.left != null) deque.add(cur.left);
                if (cur.right != null) deque.add(cur.right);
            }
            if (!sign) {// reverse
                Collections.reverse(level);
            }
            sign = !sign;
            ans.add(level);
        }
        return ans;
    }
}
