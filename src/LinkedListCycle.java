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

        while (fast != null & fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;

        }
        return false;
    }
}
