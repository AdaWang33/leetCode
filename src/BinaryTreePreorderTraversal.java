import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stk.isEmpty()) {
            if (cur != null) {
                stk.add(cur);
                ans.add(cur.val);
                cur = cur.left;
            }else{
                cur = stk.pop();
                cur = cur.right;
            }
        }
        return ans;
    }
}
