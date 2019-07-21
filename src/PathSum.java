import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 */

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        List<Integer> total  = new ArrayList<>();
        pathSum(root, total);
        return total.contains(sum);
    }

    public void pathSum(TreeNode root, List<Integer> total) {
        if(root.left==null && root.right==null){
            total.add(root.val);
            return;
        }

        if(root.left!=null){
            root.left.val+= root.val;
            pathSum(root.left, total);
        }

        if(root.right!=null){
            root.right.val += root.val;
            pathSum(root.right, total);
        }
    }
}
