import java.util.Stack;

public class MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        int ans = 0;
        Stack<Integer> stk = new Stack<>();
        stk.push(Integer.MAX_VALUE);

        for (int num : arr) {
            while (!stk.isEmpty() && stk.peek() <= num) {
                ans += stk.pop() * (Math.min(stk.peek(), num));
            }
            stk.push(num);
        }

        while (stk.size() > 2) {
            ans += stk.pop() * stk.peek();
        }
        return ans;
    }
}
