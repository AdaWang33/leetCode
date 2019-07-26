import java.util.ArrayList;
import java.util.List;

public class TwoSumIV_InputisABST {
    boolean exist = false;
    List<Integer> tree = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        inorderTraverseTree(root);
        for (int val : tree) {
            if (tree.contains(k - val) && (2 * val != k)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    public void inorderTraverseTree(TreeNode root) {
        if (root == null) return;
        inorderTraverseTree(root.left);
        tree.add(root.val);
        inorderTraverseTree(root.right);
    }
}
