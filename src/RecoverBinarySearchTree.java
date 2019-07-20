import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p>
 * Recover the tree without changing its structure.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,null,null,2]
 * <p>
 * 1
 * /
 * 3
 * \
 * 2
 * <p>
 * Output: [3,1,null,null,2]
 * <p>
 * 3
 * /
 * 1
 * \
 * 2
 * Example 2:
 * <p>
 * Input: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 * /
 * 2
 * <p>
 * Output: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 * /
 * 3
 * Follow up:
 * <p>
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        // 结合了in-order traversal的stack方法，想象左树枝由粗到细，最末端开始判断钱，先加上右树枝，等于在其和上一个节点之间插入了一段，逻辑大小关系是一致的
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode prev = null;
        TreeNode m = null, n = null;
        boolean firstTime = true;

        while (true) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            if (stk.isEmpty()) break;
            TreeNode node = stk.pop();
            if (prev != null && prev.val > node.val) {
                if (firstTime) {
                    m = prev;
                    firstTime = false;
                }
                n = node;
            }
            prev = node;
            root = node.right;
        }

        int tmp = m.val;
        m.val = n.val;
        n.val = tmp;

    }
}
