
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        s = preprocess(s);
        int max = 0;
        String maxString = "";
        for (int i = 0; i < s.length(); i++) {
            int rl = 0;
            if (i - rl > 0 && i + rl < s.length() && s[i - rl] == s[i + rl]) {
                rl++;
            }
            if (2 * rl - 1 > max) {
                max = 2 * rl - 1;
                maxString = s.substring(i - rl + 1, i + rl );
            }
        }
        return maxString;
    }

    public String preprocess(String s) {
        String ps = "#";
        for (int i = 0; i < s.length(); i++) {
            ps += s.charAt(i) + "#";
        }
        return ps;
    }
}
