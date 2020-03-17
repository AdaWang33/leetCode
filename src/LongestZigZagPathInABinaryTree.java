/**
 * Given a binary tree root, a ZigZag path for a binary tree is defined as follow:
 *
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right then move to the right child of the current node otherwise move to the left child.
 * Change the direction from right to left or right to left.
 * Repeat the second and third step until you can't move in the tree.
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 *
 * Return the longest ZigZag path contained in that tree.
 */


public class LongestZigZagPathInABinaryTree {
    int res = 0;
    public int longestZigZag(TreeNode root) {
        if(root==null) return 0;
        helper(root);
        return res-1;
    }

    public int[] helper(TreeNode node){
        if(node==null) return new int[]{0,0};
        int[] results = new int[2];
        results[0] = 1 + helper(node.left)[1];
        results[1] = 1 + helper(node.right)[0];
        res = Math.max(res, Math.max(results[0], results[1]));
        return results;
    }
}
