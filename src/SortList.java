/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */

public class SortList {
    public ListNode sortList(ListNode head) {
        // 可用的sorting为merge sort和quick sort，下面是merge sort的做法
        if (head == null || head.next == null) return head;

        // find center first
        ListNode fast = head;
        fast = fast.next.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode halfHead = slow.next;
        slow.next = null;

        // divide in half recursively
        ListNode left = sortList(head);
        ListNode right = sortList(halfHead);
        head = mergeSort(left, right);
        return head;


    }

    private ListNode mergeSort(ListNode head, ListNode halfHead){
        // do merge sort
        ListNode newHead = new ListNode(0);
        ListNode tmp = newHead;
        while (head != null && halfHead != null) {
            if (head.val <= halfHead.val) {
                tmp.next = head;
                tmp = tmp.next;
                head = head.next;
            } else {
                tmp.next = halfHead;
                tmp = tmp.next;
                halfHead = halfHead.next;
            }
            // System.out.println(tmp.next.val);
        }
        if (head != null) tmp.next = head;
        if (halfHead != null) tmp.next = halfHead;

        return newHead.next;
    }
}
