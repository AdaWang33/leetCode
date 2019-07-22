import java.util.ArrayDeque;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) return root;

        Node cur = root;
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.addLast(cur);
        while (!deque.isEmpty()) {
            int size = deque.size();
            ArrayDeque<Node> newDeque = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                cur = deque.removeFirst();
                if (!deque.isEmpty()) {
                    cur.next = deque.peek();
                } else {
                    cur.next = null;
                }
                if(cur.left!=null) newDeque.addLast(cur.left);
                if(cur.right!=null) newDeque.addLast(cur.right);
            }
            deque = newDeque;
        }
        return root;
    }
}
