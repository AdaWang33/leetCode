/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    // recursion：给一个root和树的范围，构建左树和右数（左根，范围和右根，范围）
    // preorder: 根，左子树，右子树
    // inorder: 左子树，根，右子树

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, preorder.length - 1, preorder, inorder);
    }

    public TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart < 0 || preStart >= preorder.length || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) index = i;
        }
        root.left = buildTree(preStart+1, inStart, index-1, preorder, inorder);
        root.right = buildTree(preStart+index-inStart+1, index+1, inEnd, preorder, inorder);
        return root;
    }
}
