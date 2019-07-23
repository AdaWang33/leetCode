import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        return postorderTraversal(root, ans);
    }

    public List<Integer> postorderTraversal(TreeNode root, List<Integer> ans) {
        if (root != null) {
            postorderTraversal(root.left, ans);
            postorderTraversal(root.right, ans);
            ans.add(root.val);
        }
        return ans;
    }
}
