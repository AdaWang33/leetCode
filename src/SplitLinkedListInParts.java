
public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        if (root == null) return ans;

        ListNode head = root;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        head = root;

        int basic = len / k;
        int digit = len % k;
        for (int i = 0; i < k; i++) {
            ans[i] = new ListNode(0);
            ListNode tmp = ans[i];
            for (int j = 0; j < basic + (digit > 0 ? 1 : 0); j++) {
                tmp.next = head;
                tmp = tmp.next;
                head = head.next;
                tmp.next = null;
            }
            digit--;
            ans[i] = ans[i].next;
        }
        return ans;
    }
}
