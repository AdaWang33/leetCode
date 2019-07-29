import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * List<TreeNode> list = new ArrayList<>();
 * Queue<TreeNode> queue = new LinkedList<>();
 * <p>
 * public boolean isCompleteTree(TreeNode root) {
 * if (root == null) return true;
 * levelorderTraversal(root);
 * <p>
 * for (int idx = 1; idx < list.size(); idx++) {
 * TreeNode cur = list.get(idx);
 * int parIdx;
 * TreeNode par;
 * if (idx % 2 == 1) {
 * parIdx = idx / 2;
 * par = list.get(parIdx);
 * if (par.left != cur) return false;
 * } else {
 * parIdx = idx / 2 - 1;
 * par = list.get(parIdx);
 * if (par.right != cur) return false;
 * }
 * }
 * return true;
 * }
 * <p>
 * public void levelorderTraversal(TreeNode root) {
 * queue.offer(root);
 * while (!queue.isEmpty()) {
 * int size = queue.size();
 * for (int i = 0; i < size; i++) {
 * TreeNode cur = queue.poll();
 * list.add(cur);
 * if (cur.left != null) queue.offer(cur.left);
 * if (cur.right != null) queue.offer(cur.right);
 * }
 * }
 * }
 */
public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode cur = queue.poll();
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }
}
