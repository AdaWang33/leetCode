/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        // 巧妙地组成一个圈来避免讨论k超过n的情况
        if (head == null || k == 0) {
            return head;
        }
        int num = 0;
        ListNode tmp = head;
        ListNode tmpLast = null;

        // 得到Linked List的尺寸
        while (tmp != null) {
            tmpLast = tmp;
            tmp = tmp.next;
            num++;
        }
        // 连成环
        tmpLast.next = head;

        k %= num;
        // 找到开始位置和结束位置
        for (int i = 0; i < num - k; i++) {
            tmpLast = tmpLast.next;
        }
        head = tmpLast.next;
        tmpLast.next = null;
        return head;


    }
}
