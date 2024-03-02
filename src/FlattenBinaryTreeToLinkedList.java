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
        // animation here: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/solutions/1207642/js-python-java-c-simple-o-1-space-recursive-solutions-w-explanation
        // Morris Traversal

        if(root==null) return;

        TreeNode cur = root;
        TreeNode runner;

        while(cur!=null) {
            if (cur.left==null) {
                cur = cur.right;
            } else {
                runner = cur.left;
                while(runner.right!=null) {
                    runner = runner.right;
                }
                runner.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
        }
    }
}
