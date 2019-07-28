import java.util.ArrayList;
import java.util.List;

public class Leaf_SimilarTrees {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        findLeaves(root1, l1);
        findLeaves(root2, l2);
        if (l1.equals(l2)) return true;
        return false;
    }

    public void findLeaves(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) list.add(root.val);
        if (root.left != null) findLeaves(root.left, list);
        if (root.right != null) findLeaves(root.right, list);
    }
}
