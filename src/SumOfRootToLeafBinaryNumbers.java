public class SumOfRootToLeafBinaryNumbers {
    int Sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return Sum;
        findSum(root, 0);
        return Sum;
    }
    public void findSum(TreeNode root, int sum) {
        sum = 2 * sum + root.val;
        if (root.left == null && root.right == null) {
            Sum += sum;
            return;
        }
        if (root.left != null) findSum(root.left, sum);
        if (root.right != null) findSum(root.right, sum);
    }
}
