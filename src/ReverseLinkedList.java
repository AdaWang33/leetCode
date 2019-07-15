public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // iteratively
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        head.next = null;
        return prev;


        // recursively
        if (head == null || head.next == null) return head;
        ListNode back = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return back;
    }
}
