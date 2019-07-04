import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

public class LetterCombinationsOfAPhoneNumber {


    public List<String> letterCombinations(String digits) {

        if (digits.indexOf('1') < 0) {
            digits.replaceAll("1", "");
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> ans = new ArrayList<>();
        if(digits.length()==0 || digits ==null){
            return ans;
        }
        StringBuilder temp = new StringBuilder("");
        combine(digits, 0, temp, ans, map);
        return ans;
    }

    private void combine(String digits, int i, StringBuilder temp, List<String> ans, Map map) {
        if (temp.length() == digits.length()) {
            ans.add(temp.toString());
            return;
        }

        char number = digits.charAt(i);
        String letters = map.get(number).toString();

        for (char c : letters.toCharArray()) {
            temp.append(c);
            combine(digits, i + 1, temp, ans, map);
            temp.setLength(temp.length()-1);
        }
    }
}
