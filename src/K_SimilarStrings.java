import java.util.HashMap;
import java.util.Map;

/**
 * Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of two letters in A exactly K times so that the resulting string equals B.
 *
 * Given two anagrams A and B, return the smallest K for which A and B are K-similar.
 *
 * Example 1:
 *
 * Input: A = "ab", B = "ba"
 * Output: 1
 * Example 2:
 *
 * Input: A = "abc", B = "bca"
 * Output: 2
 * Example 3:
 *
 * Input: A = "abac", B = "baca"
 * Output: 2
 * Example 4:
 *
 * Input: A = "aabc", B = "abca"
 * Output: 2
 * Note:
 *
 * 1 <= A.length == B.length <= 20
 * A and B contain only lowercase letters from the set {'a', 'b', 'c', 'd', 'e', 'f'}
 */

public class K_SimilarStrings {
    public int kSimilarity(String A, String B) {
        // dfs: backtracking, plus memorizing
        Map<String, Integer> map = new HashMap<>();
        return helper(A.toCharArray(), B, map);
    }

    public int helper(char[] As, String B, Map<String, Integer> map){
        String A = new String(As);
        if(A.equals(B)) return 0;
        if(map.containsKey(A)) return map.get(A);

        int i=0;
        while(i<A.length()&&A.charAt(i)==B.charAt(i)){
            i++;
        }

        int cnt = Integer.MAX_VALUE;
        for(int j=i+1;j<A.length();j++){
            if(A.charAt(j)==B.charAt(i)){
                swap(As, i, j);
                int nextCnt = helper(As, B, map);
                swap(As, i, j);
                cnt = Math.min(cnt, nextCnt+1);
            }
        }
        map.put(A, cnt);
        return cnt;
    }

    public void swap(char[] As, int i, int j){
        char tmp = As[i];
        As[i] = As[j];
        As[j] = tmp;
    }
}
