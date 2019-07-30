import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        boolean xExist = false, yExist = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            xExist = false;
            yExist = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == x) xExist = true;
                if (cur.val == y) yExist = true;
                if (cur.left != null && cur.right != null) {
                    if ((cur.left.val == x && cur.right.val == y) || (cur.left.val == y && cur.right.val == x))
                        return false;
                }
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            if (xExist && yExist) return true;
        }
        return false;
    }
}


/**
 * // 俩hashmap，一个存depth一个存parent
 * HashMap<TreeNode, Integer> depth = new HashMap<>();
 * HashMap<TreeNode, TreeNode> parent = new HashMap<>();
 * <p>
 * public boolean isCousins(TreeNode root, int x, int y) {
 * findParent(root, null);
 * findDepth(root, 0);
 * TreeNode xNode = null, yNode = null;
 * for (TreeNode node : parent.keySet()) {
 * if (node.val == x) xNode = node;
 * }
 * for (TreeNode node : parent.keySet()) {
 * if (node.val == y) yNode = node;
 * }
 * return ((parent.get(xNode) != parent.get(yNode)) && (depth.get(xNode) == depth.get(yNode)));
 * }
 * <p>
 * public void findParent(TreeNode root, TreeNode par) {
 * if (root == null) return;
 * parent.put(root, par);
 * findParent(root.left, root);
 * findParent(root.right, root);
 * }
 * <p>
 * public void findDepth(TreeNode root, int d) {
 * if (root == null) return;
 * depth.put(root, d);
 * findDepth(root.left, d + 1);
 * findDepth(root.right, d + 1);
 * }
 */