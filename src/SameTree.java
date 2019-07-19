import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 准备两个inorder traversal，然后进行比较:未解决添加null的问题
        // 用递归的方法！巧妙比较左左和右右

        if (p == null && q == null) return true;
        else if ((p == null && q != null) || (p != null && q == null)) return false;
        else if (p.val == q.val && isSameTree(p.left, q.left)==true && isSameTree(p.right, q.right)==true) return true;
        else return false;
        }
    }