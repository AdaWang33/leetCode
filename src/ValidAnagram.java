/**
 * 242. Valid Anagram
 * 
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[128];

        for(char c:s.toCharArray()) {
            map[c]++;
        }
        for(char c:t.toCharArray()) {
            map[c]--;
        }
        
        for(int i=0;i<map.length;i++) {
            if (map[i]!=0) return false;
        }
        return true;
    }
}
