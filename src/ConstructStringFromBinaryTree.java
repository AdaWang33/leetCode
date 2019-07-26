public class ConstructStringFromBinaryTree {
    // preorder traversal的recursion写法（同inorder traversal一样简便）

    StringBuilder ans = new StringBuilder();

    public String tree2str(TreeNode t) {
        if (t == null) return "";
        preorderTraversal(t);
        String res = ans.substring(1, ans.length() - 1).toString();
        return res;
    }

    public void preorderTraversal(TreeNode root) {
        if (root == null) return;
        ans.append("(");
        ans.append(root.val);
        if (root.left == null && root.right != null) {
            ans.append("()");
        }
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        ans.append(")");
    }
}
