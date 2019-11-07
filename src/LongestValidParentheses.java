import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int longest = 0;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else {
                if (!stk.isEmpty() && s.charAt(stk.peek()) == '(') {
                    stk.pop();
                } else {
                    stk.push(i);
                }
            }
        }
        if (stk.isEmpty()) return s.length();

        int b = stk.peek();
        longest = s.length() - stk.pop() - 1;
        while (!stk.isEmpty()) {
            int a = stk.pop();
            longest = Math.max(longest, b - a - 1);
            b = a;
        }
        longest = Math.max(longest, b);

        return longest;
    }
}
