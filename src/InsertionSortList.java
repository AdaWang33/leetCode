/**
 * Algorithm of Insertion Sort:
 * <p>
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
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

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        // 和倒转顺序一个思路，区别是要分三种情况讨论
        if (head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode ins = head.next;

        while (ins != null) {
            ListNode nex = ins.next;
            // 在最前插入
            if (ins.val <= head.val) {
                prev.next = ins.next;
                ins.next = head;
                head = ins;
            }
            else if (ins.val >= prev.val) {
                prev = ins;
            }
            else if (ins.val > head.val && ins.val < prev.val) {
                ListNode compare = head;
                while (compare.next.val < ins.val) compare = compare.next;
                prev.next = ins.next;
                ins.next = compare.next;
                compare.next = ins;

            }
            ins = nex;
        }
        return head;
    }
}
