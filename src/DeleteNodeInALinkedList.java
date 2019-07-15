public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        // 只提供要被删除的node的情况下，将它完全变成下一个node（val一样，指向下下个），从而直接跳过
        if (node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
