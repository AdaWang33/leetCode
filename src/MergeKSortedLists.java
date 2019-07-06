import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        // 利用PriorityQueue 来选出最小的一项
        if (lists.length == 0 || lists == null) {
            return null;
        }

        ListNode fakehead = new ListNode(0);
        ListNode current = fakehead;

        Queue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, (node1, node2) -> Integer.compare(node1.val, node2.val));
        for (ListNode listnode : lists) {
            if (listnode != null) {
                minHeap.add(listnode);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.remove();
            current.next = min;
            current = current.next;

            if (min.next != null) {
                minHeap.add(min.next);
            }
        }

        return fakehead.next;
    }
}
