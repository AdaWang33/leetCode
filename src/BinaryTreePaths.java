import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * Output: ["1->2->5", "1->3"]
 * <p>
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */

public class BinaryTreePaths {
    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return ans;
        String level = new String();

        buildString(root, level);
        return ans;
    }

    public void buildString(TreeNode root, String level) {
        if (root.left == null && root.right == null) {
            level += root.val;
            ans.add(level);
            return;
        }
        level += root.val;
        if (root.left != null) buildString(root.left, level + "->");
        if (root.right != null) buildString(root.right, level + "->");
    }
}
