import java.util.HashMap;
import java.util.Stack;

public class ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stk = new Stack<>(); // 记录到当前为止的score

        for (char c : S.toCharArray()) {
            if (c == '(') stk.push(0);
            else {
                int cur = stk.pop();
                if (!stk.isEmpty()) {
                    int prev = stk.pop();
                    stk.push(prev + Math.max(0, 1 * cur));
                } else stk.push(Math.max(1, 2 * cur));
            }
        }
        return stk.pop();
    }
}
