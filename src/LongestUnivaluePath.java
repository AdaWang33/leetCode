public class LongestUnivaluePath {
    int maxLength = Integer.MIN_VALUE;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        findLongest(root);
        return maxLength;
    }

    public int findLongest(TreeNode root) {
        int leftSide = root.left != null ? findLongest(root.left) : 0;
        int rightSide = root.right != null ? findLongest(root.right) : 0;
        int lLength = ((root.left != null) && (root.left.val == root.val)) ? leftSide + 1 : 0;
        int rLength = ((root.right != null) && (root.right.val == root.val)) ? rightSide + 1 : 0;
        maxLength = Math.max(maxLength, lLength + rLength);
        return Math.max(lLength, rLength);
    }
}
