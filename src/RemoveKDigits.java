import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (k == 0) return num;
        if (num.length() == k) return "0";

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stk.isEmpty() && stk.peek() > (num.charAt(i) - '0') && k > 0) {
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i) - '0');
        }
        while (k-- > 0) {
            stk.pop();
        }
        StringBuilder cur = new StringBuilder();
        for (int i = stk.size() - 1; i >= 0; i--) {
            cur.insert(0, stk.pop());
        }
        while (cur.length() > 0 && cur.charAt(0) - '0' == 0) {
            cur.deleteCharAt(0);
        }
        return cur.length() == 0 ? "0" : cur.toString();

    }
}
