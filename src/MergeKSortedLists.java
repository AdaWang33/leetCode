import java.util.PriorityQueue;
import java.util.Queue;

// 23. Merge k Sorted Lists
/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */

public class MergeKSortedLists {
    // https://leetcode.com/problems/merge-k-sorted-lists/solutions/4677050/merge-sort-approach
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        if(lists.length==1) return lists[0];

        return mergeSort(lists, 0, lists.length-1);
    }

    private ListNode mergeSort(ListNode[] lists, int left, int right) {
        if(left==right) return lists[left];

        int mid = (left+right)/2;
        ListNode leftNode = mergeSort(lists, left, mid);
        ListNode rightNode = mergeSort(lists, mid+1, right);
        return merge(leftNode, rightNode);
    }

    private ListNode merge(ListNode leftNode, ListNode rightNode){
        if(leftNode ==null) return rightNode;
        if(rightNode==null) return leftNode;
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = dummyHead;

        while(leftNode!=null && rightNode!=null) {
            if(leftNode.val <= rightNode.val) {
                curNode.next = leftNode;
                leftNode = leftNode.next;
            } else {
                curNode.next = rightNode;
                rightNode = rightNode.next;
            }
            curNode = curNode.next;
        }

        if(leftNode!=null) {
            curNode.next = leftNode;
            leftNode = leftNode.next;
            curNode = curNode.next;
        }

        if(rightNode!=null) {
            curNode.next = rightNode;
            rightNode = rightNode.next;
            curNode = curNode.next;
        }

        return dummyHead.next;
    }


    // public ListNode mergeKLists(ListNode[] lists) {
    //     // 利用PriorityQueue 来选出最小的一项
    //     if (lists.length == 0 || lists == null) {
    //         return null;
    //     }

    //     ListNode fakehead = new ListNode(0);
    //     ListNode current = fakehead;

    //     Queue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, (node1, node2) -> Integer.compare(node1.val, node2.val));
    //     for (ListNode listnode : lists) {
    //         if (listnode != null) {
    //             minHeap.add(listnode);
    //         }
    //     }

    //     while (!minHeap.isEmpty()) {
    //         ListNode min = minHeap.remove();
    //         current.next = min;
    //         current = current.next;

    //         if (min.next != null) {
    //             minHeap.add(min.next);
    //         }
    //     }

    //     return fakehead.next;
    // }
}
