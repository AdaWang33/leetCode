public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // 思路：找到中心点，前半部分倒转，然后再进行两个链表的比较
        if (head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;
        fast = fast.next.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode latHead;
        if (fast == null) { // 偶数
            latHead = slow.next;
        } else { // 奇数
            latHead = slow.next.next;
        }
        slow.next = null;

        // 反转前半部分
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
        head = prev;

        // 比较两个链表
        while (head != null) {
            if (head.val != latHead.val) return false;
            head = head.next;
            latHead = latHead.next;
        }
        return true;
    }
}
