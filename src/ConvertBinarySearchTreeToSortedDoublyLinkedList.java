import java.util.Stack;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    Node head = null;
    Node prev = null;
    public Node treeToDoublyList(Node root) {
        if(root==null) return root;
        helper(root);

        head.left = prev;
        prev.right = head;

        return head;
    }

    private void helper(Node curNode) { // in-order traversal
        if(curNode==null) return;
        helper(curNode.left);
        if (prev==null) {
            head = curNode; // no prev, do initialize here
        } else {
            prev.right = curNode; //double link
            curNode.left = prev;
        }
        prev = curNode;
        helper(curNode.right);
    }
    // public Node treeToDoublyList(Node root) {
    //     if(root==null) return root;

    //     boolean ifFirst = false;
    //     Stack<Node> stk = new Stack<>();
    //     Node cur = root;
    //     Node prev = null;
    //     Node first = null;
    //     while(cur!=null||!stk.isEmpty()){
    //         if(cur!=null){
    //             stk.push(cur);
    //             cur = cur.left;
    //         }else{
    //             cur = stk.pop();
    //             if(!ifFirst) {
    //                 first = cur;
    //                 ifFirst = true;
    //             }
    //             cur.left = prev;
    //             if(prev!=null) prev.right = cur;
    //             prev = cur;
    //             cur = cur.right;
    //         }
    //     }

    //     first.left = prev;
    //     prev.right = first;

    //     return first;
    // }
}
