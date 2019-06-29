/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment
 * which could only store integers within
 * the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem,
 * assume that your function returns 0
 * when the reversed integer overflows.
 */

public class ReverseInteger {
    public int reverse(int x) {
        String s = Integer.toString(x);
        StringBuilder result = new StringBuilder();
        Boolean neg = false;
        if (s.charAt(0) == '-') {
            neg = true;
            StringBuilder us = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                us.append(s.charAt(i));
            }
            s = us.toString();
        }
        for(int i =s.length()-1;i>-1;i--){
            if(s.charAt(s.length()-1)==0)continue;
            result.append(s.charAt(i));
        }
        String re_result = result.toString();
        int reversed = 0;
        try {
            reversed  = Integer.parseInt(re_result);
        }
        catch (NumberFormatException e)
        {
            reversed  = 0;
        }
        if(neg) return -reversed; else return reversed;
    }
}
