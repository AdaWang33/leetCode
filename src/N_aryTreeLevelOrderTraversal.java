import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class N_aryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node cur = deque.removeFirst();
                level.add(cur.val);
                for (Node child : cur.children) deque.addLast(child);
            }
            ans.add(level);
        }
        return ans;
    }
}
