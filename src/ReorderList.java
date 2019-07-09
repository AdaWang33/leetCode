/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */


public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        // 先找到中间位置
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode halfEnd = slow;
        ListNode halfBeg = slow.next;
        halfEnd.next = null;

        // 进行后半程倒序
        ListNode prev = new ListNode(0);
        ListNode cur = halfBeg;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        ListNode revBeg = prev;
        halfBeg.next = null;

        tmp = new ListNode(0);
        // 进行交叉
        while (head != null && revBeg != null) {
            tmp.next = head;
            tmp = tmp.next;
            head = head.next;

            tmp.next = revBeg;
            tmp = tmp.next;
            revBeg = revBeg.next;
        }
        if (head != null) tmp.next = head;
        if (revBeg != null) tmp.next = revBeg;

    }
}
