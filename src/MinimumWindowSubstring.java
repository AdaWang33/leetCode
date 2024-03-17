public class MinimumWindowSubstring {
    // https://leetcode.com/problems/minimum-window-substring/solutions/4677312/beats-100-users-c-java-python-javascript-explained


    /**
     * 76. Minimum Window Substring
     * Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
     */

    public String minWindow(String s, String t) {
        int[] map = new int[128];
        int count = 0;;
        for(char c:t.toCharArray()) {
            map[c]++;
            count++;
        }

        int curLeft = 0;
        int left = 0, right = 0, minRes = Integer.MAX_VALUE;
        char[] sArray = s.toCharArray();

        while(right<s.length()) {
            if(map[sArray[right++]]-- >0) {
                count--;
            }

            while(count==0) { // valid case
                if(right-left<minRes) {
                    curLeft = left;
                    minRes = right-curLeft;
                }
                
                if(map[sArray[left++]]++ ==0) { // the char in t
                    count++; // break it
                }
            }
        }     

        return minRes == Integer.MAX_VALUE? "" : s.substring(curLeft, curLeft+minRes);
    }
}
