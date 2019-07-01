/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
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
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 * <p>
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 * <p>
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 * <p>
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // 解决边界
        if (s.length() == 0) {
            if (p.length() == 0 || p.replace("*", "").length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        dp[0][0] = true;

        for (int j = 1; j < p.length() + 1; j++) {
            if (p.charAt(j-1)=='*') {
                dp[0][j] = true;
            }else{
                break;
            }
        }
        // 动态规划（dp）
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) != '*') {
                    dp[i + 1][j + 1] = dp[i][j] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
                } else{
                    dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}
