import java.util.Stack;

public class KthSmallestElementInABST {
//    public int kthSmallest(TreeNode root, int k) {
//        if (root == null) return 0;
//
//        int ans = 0;
//        Stack<TreeNode> stk = new Stack<>();
//
//        while (root != null || !stk.isEmpty()) {
//            if (root != null) {
//                stk.add(root);
//                root = root.left;
//            } else {
//                root = stk.pop();
//                if (--k == 0) {
//                    ans =  root.val;
//                    break;
//                }
//                root = root.right;
//            }
//        }
//        return ans;
//    }
    public int kthSmallest(TreeNode root, int k) {
        // inorder traversal要记住, stack: when to load, when to pop, use cur
        if(root==null) return 0;

        int cnt = 0;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stk.isEmpty()){
            if(cur!=null){
                stk.push(cur);
                cur = cur.left;
            }else{
                TreeNode node = stk.pop();
                cnt++;
                if(cnt==k) return node.val;
                cur = node.right;
            }
        }
        return cur.val;

    }
}
