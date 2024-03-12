public class DecodeWays {
    // typical dp
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        if(s.length()==1) return 1;

        int[] dp = new int[s.length()];
        dp[0]= 1;

        for(int i=1;i<s.length();i++) {
            if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2' && s.charAt(i)<'7') {
                dp[i] += i>1?dp[i-2]:1;
            } else if(s.charAt(i)=='0') {
                return 0;
            }
            if(s.charAt(i)!='0') {
                dp[i] += dp[i-1];
            }
        }
        return dp[s.length()-1];
    }
}
