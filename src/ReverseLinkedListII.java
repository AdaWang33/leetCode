/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        if (m == n) return head;
        int num = 1;
        ListNode cur = head;
        ListNode prev = new ListNode(0);
        ListNode tmp = new ListNode(0);
        ListNode end = new ListNode(0);
        ListNode begin = new ListNode(Integer.MAX_VALUE);
        ListNode last = new ListNode(Integer.MAX_VALUE);

        while (cur != null) {
            if (num < m) {
                if (num == m - 1) begin = cur;
                cur = cur.next;
            } else if (num >= m && num <= n) {
                if (num == m) end = cur;
                tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            } else {
                if (num == n + 1) last = cur;
                cur = cur.next;
            }
            num++;
        }
        if (last.val == Integer.MAX_VALUE) last = null;
        end.next = last;
        if (begin.val == Integer.MAX_VALUE) return prev;
        begin.next = prev;
        return head;
    }
}
