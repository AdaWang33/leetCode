import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stk = new Stack<>();
        int ans = 0;
        if (ops.length == 0) return ans;
        for (String str : ops) {
            if (str.equals("+")) {
                int b = stk.pop();
                int a = stk.peek();
                stk.push(b);
                stk.push(a + b);
            } else if (str.equals("D")) {
                stk.push(stk.peek() * 2);
            } else if (str.equals("C")) {
                stk.pop();
            } else {
                stk.push(Integer.parseInt(str));
            }
        }

        for (int num : stk) ans += num;
        return ans;

    }
}
