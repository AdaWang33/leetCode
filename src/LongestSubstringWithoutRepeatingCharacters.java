import java.util.Arrays;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 **/


public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int max = 0;
        Boolean[] used = new Boolean[128];
        Arrays.fill(used, Boolean.FALSE);   // always assign values
        if (s.length() == 0 || s == null) return 0;
            while (right < n) {
                if (used[s.charAt(right)] == false) {
                    used[s.charAt(right)] = true;
                    right++;
                } else {
                    max = Math.max(max, right - left);
                    while (left < right && s.charAt(left) != s.charAt(right)) {
                        used[s.charAt(left)] = false;
                        left++;
                    }
                    left++;
                    right++;
                }
            }
        max = Math.max(max, right - left);
        return max;
    }
}