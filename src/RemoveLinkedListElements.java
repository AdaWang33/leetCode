public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode prev = new ListNode(0);
        ListNode fakeHead = prev;
        prev.next = head;
        while (prev.next != null) {
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }
            else{
             prev = prev.next;
            }
        }
        return fakeHead.next;
    }
}
