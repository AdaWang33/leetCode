public class BinaryTreeTilt {
    int ans = 0;

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        findAbs(root);
        return ans;
    }

    public int findAbs(TreeNode root) {
        if (root == null) return 0;
        int left = findAbs(root.left);
        int right = findAbs(root.right);
        ans += Math.abs(left - right);
        return root.val + left + right;
    }
}

