import java.util.HashMap;
import java.util.Map;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */

public class HappyNumber {
    public boolean isHappy(int n) {
        Map<String, Integer> map = new HashMap<>();
        return helper(Integer.toString(n), map);
    }

    public boolean helper(String str, Map<String, Integer> map){
        if(str.equals("1")) return true;
        if(map.containsKey(str)&&map.get(str)>1) return false;

        int sum = 0;
        for(char c: str.toCharArray()){
            int cur = (int)(c-'0');
            sum+=cur*cur;
        }
        String newStr = Integer.toString(sum);
        map.put(newStr, map.getOrDefault(newStr, 0)+1);
        return helper(newStr, map);
    }
}
