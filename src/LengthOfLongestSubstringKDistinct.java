import java.util.HashMap;
/**
 * Given a string s and an integer k, return the length of the longest 
substring
of s that contains at most k distinct characters.

 

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
 

Constraints:

1 <= s.length <= 5 * 104
0 <= k <= 50
 */

public class LengthOfLongestSubstringKDistinct {
    //slide window to keep track of left and right, increase right until we found
    //distinct more than k and move left until it within k and update res if larger found
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0) return 0;

        int left = 0, right = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right<s.length()) {
            Character c = s.charAt(right);
            int cnt = map.getOrDefault(c,0);
            map.put(c, cnt+1);

            while(map.keySet().size()>k) {
                c = s.charAt(left);
                cnt = map.get(c);
                if(cnt==1) {
                    map.remove(c);
                } else {
                    map.put(c, cnt-1);
                }
                left++;
            }
            res = Math.max(res, right-left+1);
            right++;
        }
        return res;
    }
    
}
