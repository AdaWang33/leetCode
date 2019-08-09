import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        String s = processedString(S);
        String t = processedString(T);
        return s.equals(t);

    }
    public String processedString(String str) {
        Stack<Character> stk = new Stack<>();
        for (Character c : str.toCharArray()) {
            if (c != '#') stk.push(c);
            else {
                if (!stk.isEmpty()) stk.pop();
            }
        }
        return String.valueOf(stk);
    }
}
