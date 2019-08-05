import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    Queue<Integer> queue = new LinkedList<>();
    int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
        for (int si = queue.size(); si > 1; si--) {
            queue.offer(queue.poll());
        }
        size++;

    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        size--;
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return size == 0;
    }
}
