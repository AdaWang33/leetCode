import java.util.ArrayList;
import java.util.List;

public class N_aryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        postorderTra(root, ans);
        return ans;
    }

    public void postorderTra(Node root, List<Integer> ans) {
        for (Node child : root.children) {
            postorderTra(child, ans);
        }
        ans.add(root.val);
    }
}
