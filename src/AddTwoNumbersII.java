import java.util.Stack;

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
        // 先得到两个的位数，再逐位相加，用prev, cur,和jin来表示(实际操作后发现不可行，多项进位不好操作)
        // 可利用stack来达成不改变Linked List本身，但是又倒序的目的

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode dummy = null;
        ListNode cur = dummy;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = 0;
            sum += carry;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            int digits = sum % 10;
            carry = sum / 10;
            ListNode head = new ListNode(digits);
            head.next = cur;
            cur = head;
        }
        return cur;
    }
}
