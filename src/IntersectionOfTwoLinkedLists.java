import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) return null;

        HashSet<ListNode> hs = new HashSet<ListNode>();
        ListNode tmp = headA;

        while (tmp != null) {
            hs.add(tmp);
            tmp = tmp.next;
        }

        tmp = headB;
        while (tmp != null) {
            if(hs.contains(tmp)) return tmp;
            tmp = tmp.next;
        }
        return null;
    }
}
