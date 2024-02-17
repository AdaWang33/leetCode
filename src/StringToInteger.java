/**
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 */


// public class StringToInteger {
//     public int myAtoi(String str) {
//         // 去除空格
//         str = str.trim();
//         // 注意result的数据类型应该先是long！！
//         long result = 0;
//         int neg = 1;
//         Boolean overflow = false;
//         if (str.length() == 0 ) return 0;

//         // 排除符号项的干扰
//         if (str.charAt(0) == '-' || str.charAt(0) == '+') {
//             if (str.charAt(0) == '-') neg = -1;
//             str = str.substring(1);
//         }


//         for (int i = 0; i < str.length() && Character.isDigit(str.charAt(i)); i++) {
//             result = result * 10 + str.charAt(i) - '0';
//             // 这里判断防止溢出
//             if (result > Integer.MAX_VALUE) {
//                 overflow = true;
//                 break;
//             }
//         }
//         if (overflow) {
//             return neg == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//         }
// //        if (result * neg < Integer.MIN_VALUE) return Integer.MIN_VALUE;
// //        if (result * neg > Integer.MAX_VALUE) return Integer.MAX_VALUE;
//         return (int) result * neg;
//     }
// }


class Solution {
    public int myAtoi(String s) {
        if (s.length()==0) return 0;

        double res = 0;
        boolean digitSeen = false;
        boolean isPositive = true;
        boolean signSeen = false;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (c==' ') {
                if(digitSeen || signSeen) {
                    break;
                } else {
                    continue;
                }
            } else if(c=='+') {
                if (digitSeen || signSeen) {
                    break;
                };
                signSeen = true;
            } else if(c=='-') {
                if (digitSeen || signSeen) {
                    break;
                } else {
                    isPositive = false;
                    signSeen = true;
                }
            } else if(Character.isDigit(c)) {
                res = res*10 + c-'0';
                digitSeen = true;
            } else {
                break;
            }
        }

        res *= isPositive? 1: -1;
        
        res = Math.max(res, Integer.MIN_VALUE);
        res = Math.min(res, Integer.MAX_VALUE);

        return (int)res;
        
    }
}
