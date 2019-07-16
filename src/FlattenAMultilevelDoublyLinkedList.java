class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}

public class FlattenAMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        if (head == null) return null;

        Node cur = head;
        while (cur != null) {
            if (cur.child == null) cur = cur.next;
            else {
                Node nex = cur.next;
                Node child = flatten(cur.child);
                cur.next = child;
                child.prev = cur;
                cur.child = null;
                Node end = child;
                while (end.next != null) {
                    end = end.next;
                }
                end.next = nex;
                if (nex != null) nex.prev = end;
                cur = cur.next;
            }
        }
        return head;
    }
}
