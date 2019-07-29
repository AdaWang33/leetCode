import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CompleteBinaryTreeInserter {
    List<TreeNode> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    public CBTInserter(TreeNode root) {
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        int idx = list.size();
        list.add(node);

        if (idx % 2 == 1) {
            list.get(idx / 2).left = node;
            return list.get(idx / 2).val;
        } else {
            list.get(idx / 2 - 1).right = node;
            return list.get(idx / 2 - 1).val;
        }
    }

    public TreeNode get_root() {
        return list.get(0);
    }
}
