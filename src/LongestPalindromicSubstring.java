
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        // dp to cut down calculation 
        if(s.length()==1) return s;
        
        int res = 1, left = 0, right = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;

        for(int j=0;j<s.length();j++) {
            // dp[j][j]=true;
            for(int i=0;i<=j;i++) {
                dp[i][j] = (s.charAt(i)==s.charAt(j)) && (i>=j-2 || dp[i+1][j-1]);
                if(dp[i][j] && (j-i+1 > res)) {
                    res = j-i+1;
                    left = i;
                    right = j+1;
                }
            }
        }
        return s.substring(left, right);
    }
    // public String longestPalindrome(String s) {
    //     s = preprocess(s);
    //     int max = 0;
    //     String maxString = "";
    //     for (int i = 0; i < s.length(); i++) {
    //         int rl = 0;
    //         // while 和 if不要搞错
    //         while (i - rl > 0 && i + rl < s.length() && s.charAt(i - rl) == s.charAt(i + rl)) {
    //             rl++;
    //         }
    //         if (2 * rl - 1 > max) {
    //             max = 2 * rl - 1;
    //             maxString = s.substring(i - rl + 1, i + rl );
    //         }
    //     }
    //     String result = maxString.replaceAll("[#]","");
    //     return result;
    // }

    // public String preprocess(String s) {
    //     String ps = "#";
    //     for (int i = 0; i < s.length(); i++) {
    //         ps += s.charAt(i) + "#";
    //     }
    //     return ps;
    // }
}





