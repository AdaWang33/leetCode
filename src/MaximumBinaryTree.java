public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return findMax(nums, start, end);
    }

    public TreeNode findMax(int[] nums, int start, int end) {
        if (start > end) return null;
        int max = nums[start];
        int idx = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = findMax(nums, start, idx - 1);
        root.right = findMax(nums, idx + 1, end);
        return root;
    }
}
