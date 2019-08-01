import java.util.Stack;

public class RecoverATreeFromPreorderTraversal {
    Stack<TreeNode> stk = new Stack<>();

    public TreeNode recoverFromPreorder(String S) {
        int level;
        int val;
        for (int i = 0; i < S.length(); ) {
            for (level = 0; S.charAt(i) == '-'; i++) {
                level++;
            }
            for (val = 0; i < S.length() && S.charAt(i) != '-'; i++) {
                val = val * 10 + (S.charAt(i) - '0');
            }
            while (stk.size() > level) {
                stk.pop();
            }

            TreeNode cur = new TreeNode(val);
            if (!stk.empty()) {
                TreeNode par = stk.peek();
                if (par.left == null) par.left = cur;
                else par.right = cur;
            }
            stk.add(cur);

        }

        while (stk.size() > 1) stk.pop();
        return stk.pop();
    }
}
