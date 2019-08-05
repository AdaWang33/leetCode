import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> stk = new Stack<>();
    Stack<Integer> back = new Stack<>();
    int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        int si = stk.size();
        for (int i = 0; i < si; i++) {
            back.push(stk.pop());
        }
        stk.push(x);
        for (int i = 0; i < si; i++) {
            stk.push(back.pop());
        }
        size++;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        size--;
        return stk.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stk.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return size == 0;

    }
}
