/**
 * Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.

A string s is said to be one distance apart from a string t if you can:

Insert exactly one character into s to get t.
Delete exactly one character from s to get t.
Replace exactly one character of s with a different character to get t.
 

Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "", t = ""
Output: false
Explanation: We cannot get t from s by only one step.
 */

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals("") && t.equals("")) return false;
        
        if(s.length()<t.length()) { // make sure s is longer if not equal in length
            String temp = s;
            s = t;
            t = temp;
        }
        int lenS = s.length();
        int lenT = t.length();
        
        int pnt = 0;
        while(pnt<lenT) {
            char cS = s.charAt(pnt);
            char cT = t.charAt(pnt);
            if (cS!=cT) { // check rest
                boolean ifEditMatch = s.substring(pnt+1, s.length()).equals(t.substring(pnt+1, t.length()));
                boolean ifDeleteMatch = s.substring(pnt+1, s.length()).equals(t.substring(pnt, t.length()));
                return ifEditMatch || ifDeleteMatch;
            }
            pnt++;
        }
        return pnt==lenS-1;
    }    
}
