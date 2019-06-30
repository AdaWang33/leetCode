/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * <p>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 * <p>
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * Example 5:
 * <p>
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 * <p>
 * 建立b[][];
 * 对边界进行赋值：b[0][0]=0;
 * 我们对b[i+1][0]进行赋值，显然对于空的匹配串，b[i+1][0]的数值必须为False
 * 我们对b[0][j+1]进行赋值，其值等于j > 0 && '*' == p[j] && b[0][j - 1]；
 * <p>
 * 1）当前匹配串的字符不为’*‘：b[i + 1][j + 1] = b[i][j] && ('.' == p[j] || s[i] == p[j])
 * 2）若当前匹配串的字符为’*‘：b[i + 1][j + 1] = b[i + 1][j - 1] && j > 0 || b[i + 1][j]
 * <p>
 * || b[i][j + 1] && j > 0 && ('.' == p[j - 1] || s[i] == p[j - 1]);
 * <p>
 * 建立b[][];
 * 对边界进行赋值：b[0][0]=0;
 * 我们对b[i+1][0]进行赋值，显然对于空的匹配串，b[i+1][0]的数值必须为False
 * 我们对b[0][j+1]进行赋值，其值等于j > 0 && '*' == p[j] && b[0][j - 1]；
 * <p>
 * 1）当前匹配串的字符不为’*‘：b[i + 1][j + 1] = b[i][j] && ('.' == p[j] || s[i] == p[j])
 * 2）若当前匹配串的字符为’*‘：b[i + 1][j + 1] = b[i + 1][j - 1] && j > 0 || b[i + 1][j]
 * <p>
 * || b[i][j + 1] && j > 0 && ('.' == p[j - 1] || s[i] == p[j - 1]);
 * <p>
 * 建立b[][];
 * 对边界进行赋值：b[0][0]=0;
 * 我们对b[i+1][0]进行赋值，显然对于空的匹配串，b[i+1][0]的数值必须为False
 * 我们对b[0][j+1]进行赋值，其值等于j > 0 && '*' == p[j] && b[0][j - 1]；
 * <p>
 * 1）当前匹配串的字符不为’*‘：b[i + 1][j + 1] = b[i][j] && ('.' == p[j] || s[i] == p[j])
 * 2）若当前匹配串的字符为’*‘：b[i + 1][j + 1] = b[i + 1][j - 1] && j > 0 || b[i + 1][j]
 * <p>
 * || b[i][j + 1] && j > 0 && ('.' == p[j - 1] || s[i] == p[j - 1]);
 * <p>
 * 建立b[][];
 * 对边界进行赋值：b[0][0]=0;
 * 我们对b[i+1][0]进行赋值，显然对于空的匹配串，b[i+1][0]的数值必须为False
 * 我们对b[0][j+1]进行赋值，其值等于j > 0 && '*' == p[j] && b[0][j - 1]；
 * <p>
 * 1）当前匹配串的字符不为’*‘：b[i + 1][j + 1] = b[i][j] && ('.' == p[j] || s[i] == p[j])
 * 2）若当前匹配串的字符为’*‘：b[i + 1][j + 1] = b[i + 1][j - 1] && j > 0 || b[i + 1][j]
 * <p>
 * || b[i][j + 1] && j > 0 && ('.' == p[j - 1] || s[i] == p[j - 1]);
 * <p>
 * 建立b[][];
 * 对边界进行赋值：b[0][0]=0;
 * 我们对b[i+1][0]进行赋值，显然对于空的匹配串，b[i+1][0]的数值必须为False
 * 我们对b[0][j+1]进行赋值，其值等于j > 0 && '*' == p[j] && b[0][j - 1]；
 * <p>
 * 1）当前匹配串的字符不为’*‘：b[i + 1][j + 1] = b[i][j] && ('.' == p[j] || s[i] == p[j])
 * 2）若当前匹配串的字符为’*‘：b[i + 1][j + 1] = b[i + 1][j - 1] && j > 0 || b[i + 1][j]
 * <p>
 * || b[i][j + 1] && j > 0 && ('.' == p[j - 1] || s[i] == p[j - 1]);
 * <p>
 * 建立b[][];
 * 对边界进行赋值：b[0][0]=0;
 * 我们对b[i+1][0]进行赋值，显然对于空的匹配串，b[i+1][0]的数值必须为False
 * 我们对b[0][j+1]进行赋值，其值等于j > 0 && '*' == p[j] && b[0][j - 1]；
 * <p>
 * 1）当前匹配串的字符不为’*‘：b[i + 1][j + 1] = b[i][j] && ('.' == p[j] || s[i] == p[j])
 * 2）若当前匹配串的字符为’*‘：b[i + 1][j + 1] = b[i + 1][j - 1] && j > 0 || b[i + 1][j]
 * <p>
 * || b[i][j + 1] && j > 0 && ('.' == p[j - 1] || s[i] == p[j - 1]);
 * <p>
 * 建立b[][];
 * 对边界进行赋值：b[0][0]=0;
 * 我们对b[i+1][0]进行赋值，显然对于空的匹配串，b[i+1][0]的数值必须为False
 * 我们对b[0][j+1]进行赋值，其值等于j > 0 && '*' == p[j] && b[0][j - 1]；
 * <p>
 * 1）当前匹配串的字符不为’*‘：b[i + 1][j + 1] = b[i][j] && ('.' == p[j] || s[i] == p[j])
 * 2）若当前匹配串的字符为’*‘：b[i + 1][j + 1] = b[i + 1][j - 1] && j > 0 || b[i + 1][j]
 * <p>
 * || b[i][j + 1] && j > 0 && ('.' == p[j - 1] || s[i] == p[j - 1]);
 * <p>
 * 建立b[][];
 * 对边界进行赋值：b[0][0]=0;
 * 我们对b[i+1][0]进行赋值，显然对于空的匹配串，b[i+1][0]的数值必须为False
 * 我们对b[0][j+1]进行赋值，其值等于j > 0 && '*' == p[j] && b[0][j - 1]；
 * <p>
 * 1）当前匹配串的字符不为’*‘：b[i + 1][j + 1] = b[i][j] && ('.' == p[j] || s[i] == p[j])
 * 2）若当前匹配串的字符为’*‘：b[i + 1][j + 1] = b[i + 1][j - 1] && j > 0 || b[i + 1][j]
 * <p>
 * || b[i][j + 1] && j > 0 && ('.' == p[j - 1] || s[i] == p[j - 1]);
 * <p>
 * 建立b[][];
 * 对边界进行赋值：b[0][0]=0;
 * 我们对b[i+1][0]进行赋值，显然对于空的匹配串，b[i+1][0]的数值必须为False
 * 我们对b[0][j+1]进行赋值，其值等于j > 0 && '*' == p[j] && b[0][j - 1]；
 * <p>
 * 1）当前匹配串的字符不为’*‘：b[i + 1][j + 1] = b[i][j] && ('.' == p[j] || s[i] == p[j])
 * 2）若当前匹配串的字符为’*‘：b[i + 1][j + 1] = b[i + 1][j - 1] && j > 0 || b[i + 1][j]
 * <p>
 * || b[i][j + 1] && j > 0 && ('.' == p[j - 1] || s[i] == p[j - 1]);
 * <p>
 * 建立b[][];
 * 对边界进行赋值：b[0][0]=0;
 * 我们对b[i+1][0]进行赋值，显然对于空的匹配串，b[i+1][0]的数值必须为False
 * 我们对b[0][j+1]进行赋值，其值等于j > 0 && '*' == p[j] && b[0][j - 1]；
 * <p>
 * 1）当前匹配串的字符不为’*‘：b[i + 1][j + 1] = b[i][j] && ('.' == p[j] || s[i] == p[j])
 * 2）若当前匹配串的字符为’*‘：b[i + 1][j + 1] = b[i + 1][j - 1] && j > 0 || b[i + 1][j]
 * <p>
 * || b[i][j + 1] && j > 0 && ('.' == p[j - 1] || s[i] == p[j - 1]);
 * <p>
 * 建立b[][];
 * 对边界进行赋值：b[0][0]=0;
 * 我们对b[i+1][0]进行赋值，显然对于空的匹配串，b[i+1][0]的数值必须为False
 * 我们对b[0][j+1]进行赋值，其值等于j > 0 && '*' == p[j] && b[0][j - 1]；
 * <p>
 * 1）当前匹配串的字符不为’*‘：b[i + 1][j + 1] = b[i][j] && ('.' == p[j] || s[i] == p[j])
 * 2）若当前匹配串的字符为’*‘：b[i + 1][j + 1] = b[i + 1][j - 1] && j > 0 || b[i + 1][j]
 * <p>
 * || b[i][j + 1] && j > 0 && ('.' == p[j - 1] || s[i] == p[j - 1]);
 * <p>
 * 建立b[][];
 * 对边界进行赋值：b[0][0]=0;
 * 我们对b[i+1][0]进行赋值，显然对于空的匹配串，b[i+1][0]的数值必须为False
 * 我们对b[0][j+1]进行赋值，其值等于j > 0 && '*' == p[j] && b[0][j - 1]；
 * <p>
 * 1）当前匹配串的字符不为’*‘：b[i + 1][j + 1] = b[i][j] && ('.' == p[j] || s[i] == p[j])
 * 2）若当前匹配串的字符为’*‘：b[i + 1][j + 1] = b[i + 1][j - 1] && j > 0 || b[i + 1][j]
 * <p>
 * || b[i][j + 1] && j > 0 && ('.' == p[j - 1] || s[i] == p[j - 1]);
 */


/**
 * 建立b[][];
 * 对边界进行赋值：b[0][0]=0;
 * 我们对b[i+1][0]进行赋值，显然对于空的匹配串，b[i+1][0]的数值必须为False
 * 我们对b[0][j+1]进行赋值，其值等于j > 0 && '*' == p[j] && b[0][j - 1]；
 *
 * 1）当前匹配串的字符不为’*‘：b[i + 1][j + 1] = b[i][j] && ('.' == p[j] || s[i] == p[j])
 * 2）若当前匹配串的字符为’*‘：b[i + 1][j + 1] = b[i + 1][j - 1] && j > 0 || b[i + 1][j]
 *
 *                                                           || b[i][j + 1] && j > 0 && ('.' == p[j - 1] || s[i] == p[j - 1]);
 */


/**
 * boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
 *         dp[text.length()][pattern.length()] = true;
 *
 *         for (int i = text.length(); i >= 0; i--){
 *             for (int j = pattern.length() - 1; j >= 0; j--){
 *                 boolean first_match = (i < text.length() &&
 *                         (pattern.charAt(j) == text.charAt(i) ||
 *                                 pattern.charAt(j) == '.'));
 *                 if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
 *                     dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
 *                 } else {
 *                     dp[i][j] = first_match && dp[i+1][j+1];
 *                 }
 *             }
 *         }
 *         return dp[0][0];
 */


public class RegularExpressionMatching {
    public boolean isMatch(String text, String pattern) {
        Boolean[][] dp = new Boolean[text.length() + 1][pattern.length() + 1];
        // 边界
        dp[0][0] = true;
        for (int i = 0; i < text.length(); i++) {
            dp[i + 1][0] = false;
        }
        for (int j = 0; j < pattern.length(); j++) {
            dp[0][j + 1] = j > 0 && pattern.charAt(j) == '*' && dp[0][j - 1];
        }
        // 动态规划
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) != '*') {
                    dp[i + 1][j + 1] = dp[i][j] && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
                } else {
                    dp[i + 1][j + 1] = (dp[i + 1][j - 1] && j > 0) || dp[i + 1][j] || (dp[i][j + 1] && (text.charAt(i) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') && j > 0);

                }
            }
        }
        return dp[text.length()][pattern.length()];
    }
}



