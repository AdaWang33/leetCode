/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */

/**
 * 建立stringBuilder[],个数是numRows
 * 两个顺序：正着走，反着走
 */


public class ZigZagConversion {
    public String convert(String s, int numRows) {
        // stringBuilder是在原对象基础上添加，不生成新对象，节省空间
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();
        int i = 0;
        if (s.isEmpty() == true) {
            return "";
        }
        while(i<s.length()) {
            // 正着走
            for (int idx = 0; idx < numRows && i < s.length(); idx++) {
                sb[idx].append(s.charAt(i));
                i++;
            }
            // 反着走
            for (int idx = numRows - 2; idx >= 1 && i < s.length(); idx--) {
                sb[idx].append(s.charAt(i));
                i++;
            }
        }
        // 把sb串连在一起
        for (int idx = 1; idx < sb.length; idx++) {
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }
}


