/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */

public class FindElementsInAContaminatedBinaryTree {
    TreeNode thisroot = null;

    public FindElementsInAContaminatedBinaryTree(TreeNode root) {
        if (root.val != 0) {
            root.val = 0;
        }
        changeValue(root);
        thisroot = root;
    }

    public void changeValue(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            node.left.val = node.val * 2 + 1;
            changeValue(node.left);
        }
        if (node.right != null) {
            node.right.val = node.val * 2 + 2;
            changeValue(node.right);
        }
    }


    public boolean find(int target) {
        return find(thisroot, target);
    }

    public boolean find(TreeNode node, int target) {
        if (node.val == target) return true;
        boolean res1 = false, res2 = false;
        if (node.left != null) {
            res1 = find(node.left, target);
        }
        if (node.right != null) {
            res2 = find(node.right, target);
        }
        return res1 || res2;
    }


}
