import java.util.*;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    stk.push(stk.pop() + stk.pop());
                    break;
                case "-":
                    stk.push(-stk.pop() + stk.pop());
                    break;
                case "*":
                    stk.push(stk.pop() * stk.pop());
                    break;
                case "/":
                    int b = stk.pop();
                    int a = stk.pop();
                    stk.push(a / b);
                    break;
                default:
                    stk.push(Integer.parseInt(tokens[i]));
            }
        }
        return stk.pop();
    }
}
