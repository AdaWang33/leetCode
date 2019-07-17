/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public class DesignLinkedList {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0) return -1;
        int len = 0;
        ListNode tmp = head;

        while (tmp != null) {
            len++;
            if (len - 1 == index) return tmp.val;
            tmp = tmp.next;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (size == 0) {
            head = new ListNode(val);
            head.next = null;
            size++;
        } else {
            ListNode end = head;
            while (end.next != null) {
                end = end.next;
            }
            ListNode newNode = new ListNode(val);
            end.next = newNode;
            newNode.next = null;
            size++;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index > size) {
            return;
        }
        int cnt = 0;
        ListNode tmp = head;
        while (tmp != null) {
            cnt++;
            if (cnt == index) {
                ListNode newNode = new ListNode(val);
                ListNode nex = tmp.next;
                tmp.next = newNode;
                newNode.next = nex;
                size++;
            } else {
                tmp = tmp.next;
            }
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        ListNode tmp = head;
        int cnt = 0;
        while (tmp != null) {
            if (index - 1 == cnt) {
                tmp.next = tmp.next.next;
                size--;
                return;
            } else {
                tmp = tmp.next;
                cnt++;
            }
        }
    }
}
