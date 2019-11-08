import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
//    List<String> resList = new ArrayList<>();
//
//    public List<String> generateParenthesis(int n) {
//        buildParenthesis("", 0, 0, n);
//        return resList;
//    }
//
//    public void buildParenthesis(String str, int open, int close, int n) {
//        if (str.length() == 2 * n) {
//            resList.add(str);
//            return;
//        }
//        if (open < n) buildParenthesis(str + "(", open + 1, close, n);
//        if (close < open) buildParenthesis(str + ")", open, close + 1, n);
//    }

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        helper("", 0, n);
        return res;
    }

    public void helper(String str, int cnt, int n) {
        if (str.length() == 2 * n) {
            if (cnt == 0) res.add(str);
            return;
        }
        if (cnt < 0) return;
        helper(str + "(", cnt + 1, n);
        helper(str + ")", cnt - 1, n);

    }
}
