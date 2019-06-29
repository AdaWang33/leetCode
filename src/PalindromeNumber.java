/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 */

//public class PalindromeNumber {
//    public boolean isPalindrome(int x) {
//        String s = Integer.toString(x);
//        s = preprocess(s);
//        int center = s.length() / 2;
//        for(int rl = center;rl>0;rl--){
//            if(s.charAt(center+rl)!=s.charAt(center-rl)){
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private String preprocess(String str) {
//        StringBuilder result = new StringBuilder();
//        result.append('#');
//        for (int i = 0; i < str.length(); i++) {
//            result.append(str.charAt(i));
//            result.append('#');
//        }
//        return result.toString();
//    }
//}

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int rx = 0;
        int tx = x;
        while (tx > 0) {
            rx = 10 * rx + tx % 10;
            tx /= 10;
        }
        if (rx == x) return true;
        return false;
    }
}

