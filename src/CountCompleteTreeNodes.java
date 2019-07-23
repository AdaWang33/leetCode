import java.util.Stack;


public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
//        if (root == null) return 0;
//        return countNodes(root.left) + countNodes(root.right) + 1;

        return (root == null) ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}


/**
 * //  随便用个traversal遍历一下？
 * int ans = 0;
 * if (root == null) return ans;
 * <p>
 * Stack<TreeNode> stk = new Stack<>();
 * TreeNode cur = root;
 * <p>
 * while (cur != null || !stk.isEmpty()) {
 * if (cur != null) {
 * stk.add(cur);
 * cur = cur.left;
 * }else{
 * cur = stk.pop();
 * ans++;
 * cur = cur.right;
 * }
 * }
 * return ans;
 */