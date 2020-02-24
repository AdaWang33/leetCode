/**
 * Given an integer num, find the closest two integers in absolute difference whose product equals num + 1 or num + 2.
 *
 * Return the two integers in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 8
 * Output: [3,3]
 * Explanation: For num + 1 = 9, the closest divisors are 3 & 3, for num + 2 = 10, the closest divisors are 2 & 5, hence 3 & 3 is chosen.
 * Example 2:
 *
 * Input: num = 123
 * Output: [5,25]
 * Example 3:
 *
 * Input: num = 999
 * Output: [40,25]
 *
 *
 * Constraints:
 *
 * 1 <= num <= 10^9
 */


public class ClosestDivisors {
    public int[] closestDivisors(int num) {
        int[] res = new int[2];
        int diff = Integer.MAX_VALUE;
        int large = num+2;
        int small = num+1;
        for(int i=(int)Math.sqrt(large);i>0;i--){
            if(large%i==0){
                int rest = large/i;
                diff = Math.abs(rest-i);
                res[0] = i;
                res[1] = rest;
                break;

            }
        }

        for(int i=(int)Math.sqrt(small);i>0;i--){
            if(small%i==0){
                int rest = small/i;
                if(Math.abs(rest-i)<diff){
                    diff = Math.abs(rest-i);
                    res[0] = i;
                    res[1] = rest;
                    break;
                }
            }
        }

        return res;
    }
}
