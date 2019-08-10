import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!stk.isEmpty() && c == stk.peek()) stk.pop();
            else stk.push(c);
        }
        while (!stk.isEmpty()) ans.insert(0, stk.pop());
        return ans.toString();
    }
}
