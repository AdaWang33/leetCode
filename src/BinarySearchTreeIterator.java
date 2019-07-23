import java.util.Stack;

public class BinarySearchTreeIterator {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Stack<TreeNode> stk = new Stack<>();
    TreeNode cur;

    public BSTIterator(TreeNode root) {
        cur = root;
        pushLeft(cur);
    }

    public void pushLeft(TreeNode cur) {
        while (cur != null) {
            stk.add(cur);
            cur = cur.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        cur = stk.pop();
        pushLeft(cur.right);
        return cur.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stk.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
