import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stk = new Stack<>(); // 存的是idx

        for (int i = T.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && T[stk.peek()] <= T[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) ans[i] = 0;
            else ans[i] = stk.peek() - i;
            stk.push(i);
        }

        return ans;

    }
}
