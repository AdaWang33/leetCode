import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FlipBinaryTreeToMatchPreorderTraversal {
    int idx = 0;
    List<Integer> ans = new ArrayList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return ifMatch(root, voyage) ? ans : Arrays.asList(-1);
    }

    public boolean ifMatch(TreeNode root, int[] voyage) {
        if (root == null) return true;
        if (root.val != voyage[idx++]) return false;
        if (root.left != null && root.left.val != voyage[idx]) {
            ans.add(root.val);
            return ifMatch(root.right, voyage) && ifMatch(root.left, voyage);
        }
        return ifMatch(root.left, voyage) && ifMatch(root.right, voyage);
    }
}
