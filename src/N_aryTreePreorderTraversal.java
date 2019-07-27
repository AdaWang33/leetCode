import java.util.ArrayList;
import java.util.List;

public class N_aryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        preorder(root, ans);
        return ans;
    }

    public void preorder(Node root, List<Integer> ans) {
        ans.add(root.val);
        for (Node child : root.children) {
            preorder(child, ans);
        }
    }
}
