import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;

        while(!queue.isEmpty()){
            int n = queue.size();
            sum = 0;
            for(int i=0;i<n;i++){
                TreeNode cur = queue.peek();
                queue.poll();
                sum += cur.val;
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
        }
        return sum;
    }
}
