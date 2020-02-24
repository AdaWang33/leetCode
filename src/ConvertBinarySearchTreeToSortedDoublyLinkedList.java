import java.util.Stack;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    public Node treeToDoublyList(Node root) {
        if(root==null) return root;

        boolean ifFirst = false;
        Stack<Node> stk = new Stack<>();
        Node cur = root;
        Node prev = null;
        Node first = null;
        while(cur!=null||!stk.isEmpty()){
            if(cur!=null){
                stk.push(cur);
                cur = cur.left;
            }else{
                cur = stk.pop();
                if(!ifFirst) {
                    first = cur;
                    ifFirst = true;
                }
                cur.left = prev;
                if(prev!=null) prev.right = cur;
                prev = cur;
                cur = cur.right;
            }
        }

        first.left = prev;
        prev.right = first;

        return first;
    }
}
