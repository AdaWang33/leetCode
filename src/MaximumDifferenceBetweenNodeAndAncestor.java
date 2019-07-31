import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * int Diff = 0;
 * HashMap<TreeNode, TreeNode> map = new HashMap<>();
 * List<TreeNode> list = new ArrayList<>();
 * <p>
 * public int maxAncestorDiff(TreeNode root) {
 * getParent(root, root);
 * findLeaf(root);
 * for (TreeNode node : list) {
 * List<Integer> val = new ArrayList<>();
 * val.add(root.val);
 * int max = root.val, min = root.val;
 * while (map.get(node) != node) {
 * val.add(node.val);
 * max = Math.max(max, node.val);
 * min = Math.min(min, node.val);
 * node = map.get(node);
 * }
 * Diff = Math.max(Diff, Math.abs(max - min));
 * }
 * return Diff;
 * }
 * <p>
 * public void getParent(TreeNode root, TreeNode par) {
 * if (root == null) return;
 * map.put(root, par);
 * getParent(root.left, root);
 * getParent(root.right, root);
 * }
 * <p>
 * public void findLeaf(TreeNode root) {
 * if (root == null) return;
 * if (root.left == null && root.right == null) list.add(root);
 * findLeaf(root.left);
 * findLeaf(root.right);
 * }
 */

public class MaximumDifferenceBetweenNodeAndAncestor {
    int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        maxAncestorDiff(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return maxDiff;
    }

    public void maxAncestorDiff(TreeNode root, int min, int max) {
        if (root == null) {
            maxDiff = Math.max(maxDiff, max - min);
            return;
        }
        maxAncestorDiff(root.left, Math.min(min, root.val), Math.max(max, root.val));
        maxAncestorDiff(root.right, Math.min(min, root.val), Math.max(max, root.val));
    }
}
