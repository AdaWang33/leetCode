import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {
    /** 314
     * Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).

        If two nodes are in the same row and column, the order should be from left to right.
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = 0;
        int max = 0;

        nodeQueue.offer(root);
        levelQueue.offer(0);

        while(!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.poll();
            Integer curLevel = levelQueue.poll();
            min = Math.min(min, curLevel);
            max = Math.max(max, curLevel);

            List<Integer> curList = map.getOrDefault(curLevel, new ArrayList<>());
            curList.add(curNode.val);
            map.put(curLevel, curList);

            if(curNode.left!=null) {
                nodeQueue.offer(curNode.left);
                levelQueue.offer(curLevel-1);
            }

            if(curNode.right!=null) {
                nodeQueue.offer(curNode.right);
                levelQueue.offer(curLevel+1);
            }
        }

        for (int i=min;i<=max; i++){
            res.add(map.get(i));
        }

        return res;
    }
}
