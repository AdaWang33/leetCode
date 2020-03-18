import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary search tree, return a balanced binary search tree with the same node values.
 *
 * A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.
 *
 * If there is more than one answer, return any of them.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,2,null,3,null,4,null,null]
 * Output: [2,1,3,null,null,null,4]
 * Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is also correct.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is between 1 and 10^4.
 * The tree nodes will have distinct values between 1 and 10^5.
 */

public class BalanceABinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        // step 1: traverse tree to get sorted array
        // step 2: turn sorted array into BST

        // step 1
        if(root==null) return root;
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<>();
        while(cur!=null||!stk.isEmpty()){
            if(cur!=null){
                stk.push(cur);
                cur = cur.left;
            }else{
                TreeNode tmp = stk.pop();
                list.add(tmp.val);
                cur = tmp.right;
            }
        }
        int[] nums = new int[list.size()];
        for(int i=0;i<list.size();i++){
            nums[i] = list.get(i);
        }
        return helper(nums);
    }

    public TreeNode helper(int[] nums){
        return sortedBST(nums, 0, nums.length-1);
    }

    public TreeNode sortedBST(int[] nums, int begin, int end){
        if(begin>end) return null;

        int mid = begin + (end-begin)/2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = sortedBST(nums, begin, mid-1);
        midNode.right = sortedBST(nums, mid+1, end);
        return midNode;
    }
}
