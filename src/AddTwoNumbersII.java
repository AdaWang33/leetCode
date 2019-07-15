/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 先得到两个的位数，再逐位相加，用prev, cur,和jin来表示
        int len1 = 0, len2 = 0;
        ListNode tmp1 = l1, tmp2 = l2;
        while (tmp1 != null) {
            len1++;
            tmp1 = tmp1.next;
        }
        while (tmp2 != null) {
            len2++;
            tmp2 = tmp2.next;
        }
        if (len1 <= len2) {
            tmp1 = l1;
            l1 = l2;
            l2 = tmp1;
            int tmp = 0;
            tmp = len1;
            len1 = len2;
            len2 = tmp;
        }

        // 开始逐位相加
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (len1 != len2) {
            prev.next = l1;
            prev = prev.next;
            l1 = l1.next;
            len1--;
        }

        while (len1 > 0) {
            int sum = l1.val+l2.val;
            int jin = sum/10;
            int rem = sum%10;
            ListNode cur = new ListNode(rem);
            prev.val += jin;
            prev.next = cur;
            prev = prev.next;
            l1 = l1.next;
            l2 = l2.next;
            len1--;
        }
        return dummy.next;
    }
}
