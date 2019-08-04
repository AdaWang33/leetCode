import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] pathDivi = path.split("/");
        Stack<String> stk = new Stack<>();
        Set<String> set = new HashSet<>(Arrays.asList(".", "..", "/", ""));

        for (String str : pathDivi) {
            if (!stk.isEmpty() && str.equals("..")) {
                stk.pop();
            } else if (!set.contains(str)) {
                stk.push(str);
            }
        }
        String ans = "";
        for (String str : stk) {
            ans += "/" + str;
        }
        return ans.isEmpty() ? "/" : ans;
    }
}
