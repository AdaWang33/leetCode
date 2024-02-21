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
            } // smart way to identify strings belonging to same group
            String tmpKey = Arrays.toString(tmpArray);
            List<String> tmpValue = map.getOrDefault(tmpKey, new ArrayList<>());
            tmpValue.add(str);
            map.put(tmpKey, tmpValue);
        }

        return new ArrayList<>(map.values());





        /*
         * List<List<String>> res = new ArrayList<>();
        HashMap<String, List> map = new HashMap<>();
        for(int i=0;i<strs.length;i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            str = new String(chars);

            if(map.containsKey(str)) {
                map.get(str).add(i);
            } else {
                List<Integer> cur = new ArrayList<>();
                cur.add(i);
                map.put(str, cur);
            }
        }

        for(List<Integer> value : map.values()) {
            List<String> curRes = new ArrayList<>();
            value.stream().forEach(index-> curRes.add(strs[(int)index]));
            res.add(curRes);
        }

        return res;
         */
    }
}
