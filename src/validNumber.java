class Solution {
    // https://leetcode.com/problems/valid-number/description/
    public boolean isNumber(String s) {
        //  
        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c=='+' || c=='-') {
                if(i>0 && s.charAt(i-1)!='e' && s.charAt(i-1)!='E') {
                    return false;
                }
            } else if (c=='e' || c=='E') {
                if(!digitSeen || eSeen){
                    return false;
                }
                eSeen = true;
                digitSeen = false;
            } else if (c=='.') {
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if(Character.isDigit(c)) {
                digitSeen = true;
            } else {
                return false;
            }
        }
            return digitSeen;
    }
}