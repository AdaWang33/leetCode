/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode prev = head;
        ListNode cur = head.next;
        List<Integer> num = new ArrayList<>();
        num.add(head.val);

        while (cur != null) {
            if(num.contains(cur.val)){
                prev.next = cur.next;
                cur = cur.next;
            }else{
                num.add(cur.val);
                prev = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
