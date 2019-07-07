/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        // 利用递归来做，给一个node，返回两个排好序的node
        if (head == null || head.next == null) return head;

        ListNode left = head;
        ListNode right = head.next;
        ListNode tempNext = head.next.next;

        head = right;
        head.next = left;
        head.next.next = swapPairs(tempNext);
        return head;

    }
}


/**
 * ListNode dummy = new ListNode(0);
 * ListNode current = dummy;
 * ListNode left = head;
 * ListNode right = head.next;
 * ListNode temp = right.next;
 * <p>
 * <p>
 * while (temp != null) {
 * left = temp;
 * while (left.next != null) {
 * right = left.next;
 * temp = right.next;
 * }
 * <p>
 * current.next = right;
 * right.next = left;
 * left.next = temp;
 * <p>
 * }
 */
