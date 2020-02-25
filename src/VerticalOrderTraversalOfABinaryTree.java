import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
    class Node{
        int val;
        int x;
        int y;
        Node left;
        Node right;
        Node(int val, int x, int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    int min = 0;
    int max = 0;
    Map<Integer, PriorityQueue<Node>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        map = new HashMap<>();
        Node curRoot = helper(root, 0,0);

        for(int i=min;i<=max;i++){
            PriorityQueue<Node> pq = map.get(i);
            List<Integer> tmp = new ArrayList<>();
            while(!pq.isEmpty()){
                tmp.add(pq.poll().val);
            }
            res.add(tmp);
        }

        return res;

    }

    public Node helper(TreeNode tnode, int x, int y){
        if(tnode==null) return null;
        Node cur = new Node(tnode.val, x, y);
        min = Math.min(x, min);
        max = Math.max(x, max);
        PriorityQueue<Node> pq = map.getOrDefault(x, new PriorityQueue<Node>((a,b)->{
            if(a.y==b.y) return Integer.compare(a.val, b.val);
            else return Integer.compare(a.y, b.y);
        }));
        pq.offer(cur);
        map.put(x, pq);
        cur.left = helper(tnode.left, x-1, y+1);
        cur.right = helper(tnode.right, x+1, y+1);
        return cur;
    }
}
