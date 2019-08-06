import java.util.HashMap;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();
        boolean[] visited = new boolean[26];
        char[] cArray = s.toCharArray();
        int[] cnt = new int[26];
        for (char c : cArray) cnt[c - 'a']++;

        for (char c : cArray) {
            cnt[c - 'a']--;     // 后面的个数
            if (visited[c - 'a']) continue;
            while (!stk.isEmpty() && stk.peek() > c && cnt[stk.peek() - 'a'] > 0) {
                visited[stk.peek() - 'a'] = false;
                stk.pop();
            }
            stk.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stk) {
            sb.append(c);
        }
        return sb.toString();
    }
}
