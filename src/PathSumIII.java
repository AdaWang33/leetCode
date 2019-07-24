public class PathSumIII {
    int cnt = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        beginsAt(root, sum);
        return cnt;
    }

    public void beginsAt(TreeNode root, int sum) {
        if (root == null) return;
        findPath(root, sum);
        beginsAt(root.left, sum);
        beginsAt(root.right, sum);
    }

    public void findPath(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        if (sum == 0) cnt++;
        findPath(root.left, sum);
        findPath(root.right, sum);
    }
}
