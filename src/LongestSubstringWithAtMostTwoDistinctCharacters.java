public class LongestSubstringWithAtMostTwoDistinctCharacters {
    /**
     * Hard
Given a string s, find the length of the longest substring t that contains at most 2 distinct characters.
Example 1:
Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:
Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
Related Problems
Longest Substring with At Most K Distinct Characters
     */

     public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s==null || s.length()<3) return s.length();

        int[] map = new int[128];
        char[] sArray = s.toCharArray();
        int left=0, right=0, count=0;
        int maxRes = Integer.MIN_VALUE;

        while(right<s.length()) {
            if(map[sArray[right++]]++ ==0) {
                count++;
            }

            while(count > 2){ // invalid
                if(map[sArray[left++]]-- ==1) {
                    count--;
                }
            }
            // valid now
            maxRes = Math.min(maxRes, right-left);
        }

        return maxRes;
     }
}
