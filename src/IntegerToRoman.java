/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: "III"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "IV"
 * Example 3:
 * <p>
 * Input: 9
 * Output: "IX"
 * Example 4:
 * <p>
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 * <p>
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */


public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        StringBuilder[] indexSt = new StringBuilder[10];
        indexSt[0] = new StringBuilder("0");
        for (int i = 1; i < 10; i++) {
            indexSt[i] = new StringBuilder();
//            if (i < 4 && i > 0) {
//                indexSt[i].append('0' * i);
////                System.out.println(indexSt[i]);
//            } else if (i == 4) indexSt[i].append('1');
//            else if (4 < i && i < 9) {
//                indexSt[i].append('1');
//                indexSt[i].append('0' * (i - 5));
//            } else if (i == 9) indexSt[i].append("12");
        }
            indexSt[1].append("0");
            indexSt[2].append("00");
            indexSt[3].append("000");
            indexSt[4].append("01");
            indexSt[5].append("1");
            indexSt[6].append("10");
            indexSt[7].append("100");
            indexSt[8].append("1000");
            indexSt[9].append("12");




        String symbol[][] = {
                {"I", "V", "X"},
                {"X", "L", "C"},
                {"C", "D", "M"},
                {"M"}
        };

        String str = Integer.toString(num);

        for (int i = 0; i < str.length(); i++) {
            for(int j=0;j<indexSt[i].length();j++){
                int symIdx = str.length()-i-1;
                result.append(symbol[symIdx][indexSt[str.charAt(i)].charAt(j)]);
            }
        }
        String ans = result.toString();
        return ans;
    }
}
