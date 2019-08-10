public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        // 根据'('的等级决定要不要把'('和对应等级的')'放入ans

        StringBuilder ans = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && level++ > 0) ans.append(c);
            if (c == ')' && level-- > 1) ans.append(c);
        }
        return ans.toString();
    }
}
