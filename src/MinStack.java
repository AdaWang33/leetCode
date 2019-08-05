import java.util.Stack;

public class MinStack {
    Stack<Integer> stk;
    int MIN = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stk = new Stack<>();
    }

    public void push(int x) {
        stk.push(x);
        MIN = Math.min(MIN, x);
    }

    public void pop() {
        stk.pop();
        MIN = Integer.MAX_VALUE;
        for (int i : stk) {
            MIN = Math.min(MIN, i);
        }
    }

    public int top() {
        int res = stk.peek();
        return res;
    }

    public int getMin() {
        return MIN;
    }
}
