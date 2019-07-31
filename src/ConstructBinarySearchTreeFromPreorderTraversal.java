public class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        return findRoot(preorder, 0, preorder.length - 1);
    }

    public TreeNode findRoot(int[] preorder, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(preorder[start]);
        TreeNode root = new TreeNode(preorder[start]);
        int rightIdx = start;
        for (int i = start; i <= end; i++) {
            if (preorder[i] > preorder[start]) {
                rightIdx = i;
                break;
            }
        }
        if (rightIdx == start) {
            root.right = null;
            root.left = findRoot(preorder, start + 1, end);
        } else {
            root.left = findRoot(preorder, start + 1, rightIdx - 1);
            root.right = findRoot(preorder, rightIdx, end);
        }
        return root;
    }
}
