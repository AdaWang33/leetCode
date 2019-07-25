import java.util.*;

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                root = deque.removeFirst();
                level.add(root.val);
                if (root.left != null) deque.addLast(root.left);
                if (root.right != null) deque.addLast(root.right);
            }
            Collections.sort(level);
            ans.add(level.get(level.size()-1));
        }
        return ans;
    }
}
