public class SmallestStringStartingFromLeaf {
    String ans = null;

    public String smallestFromLeaf(TreeNode root) {
        findString(root, new StringBuilder());
        return ans;
    }

    public void findString(TreeNode root, StringBuilder sb) {
        sb.insert(0, (char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            if (ans == null || sb.toString().compareTo(ans) < 0) ans = sb.toString();
        }
        if (root.left != null) findString(root.left, sb);
        if (root.right != null) findString(root.right, sb);
        sb.deleteCharAt(0);
    }
}
