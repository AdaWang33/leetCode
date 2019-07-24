import java.util.Stack;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;

        int ans = 0;
        Stack<TreeNode> stk = new Stack<>();

        while (root != null || !stk.isEmpty()) {
            if (root != null) {
                stk.add(root);
                root = root.left;
            } else {
                root = stk.pop();
                if (--k == 0) {
                    ans =  root.val;
                    break;
                }
                root = root.right;
            }
        }
        return ans;
    }
}
