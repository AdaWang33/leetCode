import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ValidParentheses {
    Stack<Character> stk = new Stack<>();
    HashMap<Character, Character> map = new HashMap<>();

    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stk.add(s.charAt(i));
            } else {
                if (stk.isEmpty()) return false;
                if (map.get(stk.pop()) != s.charAt(i)) return false;
            }
        }
        if (stk.isEmpty()) return true;
        else return false;
    }
}
