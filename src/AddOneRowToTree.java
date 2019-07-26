import java.util.ArrayList;
import java.util.List;

public class AddOneRowToTree {
    List<TreeNode> prev = new ArrayList<>();

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return null;
        if(d==1){
            TreeNode tmp = new TreeNode(v);
            tmp.left = root;
            return tmp;
        }
        int depth = 1;
        findPrev(root, depth, d);

        for(TreeNode cur : prev){
            if (cur == null) return null;
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            cur.left = new TreeNode(v);
            cur.right = new TreeNode(v);
            cur.left.left = left;
            cur.right.right = right;
        }

        return root;
    }

    public void findPrev(TreeNode root, int depth, int d) {
        if (depth == d - 1 && root != null) {
            prev.add(root);
            return;
        }
        if(root==null) return;
        findPrev(root.left, depth + 1, d);
        findPrev(root.right, depth + 1, d);
    }


}
