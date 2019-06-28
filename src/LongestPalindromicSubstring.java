
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        s = preprocess(s);
        int max = 0;
        String maxString = "";
        for (int i = 0; i < s.length(); i++) {
            int rl = 0;
            // while 和 if不要搞错
            while (i - rl > 0 && i + rl < s.length() && s.charAt(i - rl) == s.charAt(i + rl)) {
                rl++;
            }
            if (2 * rl - 1 > max) {
                max = 2 * rl - 1;
                maxString = s.substring(i - rl + 1, i + rl );
            }
        }
        String result = maxString.replaceAll("[#]","");
        return result;
    }

    public String preprocess(String s) {
        String ps = "#";
        for (int i = 0; i < s.length(); i++) {
            ps += s.charAt(i) + "#";
        }
        return ps;
    }
}





