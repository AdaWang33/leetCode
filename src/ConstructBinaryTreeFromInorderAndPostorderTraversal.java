/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    public TreeNode buildTree(int postStart, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (postStart < 0 || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postStart]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }
        root.right = buildTree(postStart - 1, index + 1, inEnd, inorder, postorder);
        root.left = buildTree(postStart - inEnd + index - 1, inStart, index - 1, inorder, postorder);
        return root;
    }
}
