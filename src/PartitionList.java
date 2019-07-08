/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode lesHead = new ListNode(0);
        ListNode lesCur = lesHead;
        ListNode greHead = new ListNode(0);
        ListNode greCur = greHead;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                lesCur.next = new ListNode(cur.val);
                lesCur = lesCur.next;
            } else {
                greCur.next = new ListNode(cur.val);
                greCur = greCur.next;
            }
            cur = cur.next;
        }

        lesCur.next = greHead.next;
        greCur.next = null;
        return lesHead.next;

    }
}
