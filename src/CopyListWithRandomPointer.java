/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * <p>
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 * <p>
 * <p>
 * Note:
 * <p>
 * You must return the copy of the given head as a reference to the cloned list.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public Node next;
 * public Node random;
 * <p>
 * public Node() {}
 * <p>
 * public Node(int _val,Node _next,Node _random) {
 * val = _val;
 * next = _next;
 * random = _random;
 * }
 * };
 */

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        // 巧用hashmap
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;

        while (cur != null) {
            map.put(cur, new Node(cur.val, cur, cur));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);

    }
}
