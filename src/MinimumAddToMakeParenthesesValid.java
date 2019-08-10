import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        if (S.length() == 0) return 0;
        Stack<Character> stk = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == '(') stk.push(c);
            else {
                if (!stk.isEmpty() && stk.peek() == '(') stk.pop();
                else stk.push(c);
            }
        }
        return stk.size();
    }
}
