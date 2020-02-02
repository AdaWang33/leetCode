/**
 * Given a binary tree root. Split the binary tree into two subtrees by removing 1 edge such that the product of the sums of the subtrees are maximized.
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 */

public class MaximumProductOfSplittedBinaryTree {
    long res;
    long sum;
    public int maxProduct(TreeNode root) {
        res = 0;
        sum = helper(root);
        helper2(root);
        // return res<(10^9+7)?res:res%(10^9 + 7);
        // return (res*(res+1)*(2*res+1)/6)%(10^9 + 7);
        // return res;
        return (int)(res % ((int)Math.pow(10, 9) + 7));
    }

    public long helper(TreeNode node){
        if(node==null) return 0;
        return node.val + helper(node.left) + helper(node.right);
    }

    public long helper2(TreeNode node){
        if(node==null) return 0;
        long curSum = node.val + helper2(node.left) + helper2(node.right);
        if(((sum-curSum)*curSum)>res) res = (sum-curSum)*curSum;
        // System.out.println(res);
        return curSum;
    }
}
