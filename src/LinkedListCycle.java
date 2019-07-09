/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */


public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // 套圈！！
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        fast = fast.next.next;

        while (fast != null & fast.next != null) {
            if (fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;

        }
        return false;
    }
}
