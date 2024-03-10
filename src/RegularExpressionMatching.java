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
 */

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        // set boundary
        for(int i=0;i<s.length();i++) {
            dp[i+1][0] = false;
        }

        for(int i=0;i<p.length();i++) {
            dp[0][i+1] = i>0 && dp[0][i-1] && p.charAt(i)=='*'; // repeat 0 time
        }

        for(int i=0;i<s.length();i++) {
            for(int j=0;j<p.length();j++) {
                if(p.charAt(j)!='*') {
                    dp[i+1][j+1] = dp[i][j]&& (s.charAt(i) == p.charAt(j) || p.charAt(j)=='.');
                } else {
                    dp[i+1][j+1] = (j>0 && dp[i+1][j-1]) // repeat 0 time
                    || dp[i+1][j] // repeat 1 time
                    || (j>0 && dp[i][j+1] && (s.charAt(i)==p.charAt(j-1) || p.charAt(j-1)=='.')); // repeat 1+ times, special case: prev char is '.'
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}



