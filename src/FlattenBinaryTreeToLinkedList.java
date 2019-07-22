import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example, given the following tree:
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null) {
            if (cur.left == null) cur = cur.right;
            else {
                prev = cur.left;
                while (prev.right != null) prev = prev.right;
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
        }
    }
}
