import java.util.Stack;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * The successor of a node p is the node with the smallest key greater than p.val.
 *
 * If the given node has no in-order successor in the tree, return null.
 * It's guaranteed that the values of the tree are unique.
 */

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // try inorder traversal first
        int status = 0;
        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<>();

        while(cur!=null | !stk.isEmpty()){
            if(cur!=null){
                stk.push(cur);
                cur = cur.left;
            }else{
                TreeNode node = stk.pop();
                if(status==1) return node;
                cur = node.right;
                if(node==p) status++;
            }
        }
        return null;
    }
}
