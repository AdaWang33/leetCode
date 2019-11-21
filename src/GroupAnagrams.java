import java.sql.Struct;
import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] tmpArray = new int[26];
            for (char c : str.toCharArray()) {
                tmpArray[c - 'a'] += 1;
            }
            String tmpKey = Arrays.toString(tmpArray);
            List<String> tmpValue = map.getOrDefault(tmpKey, new ArrayList<>());
            tmpValue.add(str);
            map.put(tmpKey, tmpValue);
        }

        return new ArrayList<>(map.values());
    }
}
