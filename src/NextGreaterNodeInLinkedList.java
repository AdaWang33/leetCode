/**
 * We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
 * <p>
 * Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.
 * <p>
 * Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
 * <p>
 * Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.
 */

public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        // 思路：如果cur比prev的值要大，那么就直接从prev定的tmp开始；若不是，则tmp定位cur，然后开始精确定位；
        // 注意！！！要先判断！=null然后再比较大小，不然会出现nullpointer exception 错误！
        if (head == null) return null;
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        int[] ans = new int[len];

        ListNode cur = head;
        ListNode prev = new ListNode(0);
        tmp = cur;
        int val;
        int i = 0;

        while (cur != null) {
            if (cur.val < prev.val) tmp = cur;
            while (tmp != null && cur.val >= tmp.val) {
                tmp = tmp.next;
            }
            if (tmp == null) {
                ans[i] = 0;
                tmp = cur.next;
            } else {
                val = tmp.val;
                ans[i] = val;
            }
            i++;
            prev = cur;
            cur = cur.next;
        }
        return ans;
    }
}
