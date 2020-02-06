/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = -2, b = 3
 * Output: 1
 */

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if(a==0) return b;
        if(b==0) return a;

        int carry;
        while(b!=0){
            carry = a&b; // and
            a = a^b; // xor
            b = carry<<1;
        }
        return a;
    }
}

/**
 * // Iterative
 * public int getSum(int a, int b) {
 * 	if (a == 0) return b;
 * 	if (b == 0) return a;
 *
 * 	while (b != 0) {
 * 		int carry = a & b;
 * 		a = a ^ b;
 * 		b = carry << 1;
 *        }
 *
 * 	return a;
 * }
 *
 * // Iterative
 * public int getSubtract(int a, int b) {
 * 	while (b != 0) {
 * 		int borrow = (~a) & b;
 * 		a = a ^ b;
 * 		b = borrow << 1;
 *    }
 *
 * 	return a;
 * }
 *
 * // Recursive
 * public int getSum(int a, int b) {
 * 	return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
 * }
 *
 * // Recursive
 * public int getSubtract(int a, int b) {
 * 	return (b == 0) ? a : getSubtract(a ^ b, (~a & b) << 1);
 * }
 *
 * // Get negative number
 * public int negate(int x) {
 * 	return ~x + 1;
 * }
 */
