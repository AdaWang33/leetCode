/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * <p>
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * <p>
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */


public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode current = head;
        ListNode tmp = head;
        if (head == null || head.next == null) return head;

        for (int i = 0; i < k - 1; i++) {
            tmp = tmp.next;
            if (tmp == null) return head;
        }

        for (int i = 0; i < k; i++) {
            tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        head.next = reverseKGroup(current, k);
        return prev;

    }
}
