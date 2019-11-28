/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */


/**
 * we can XOR all bits together to find the unique number.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        // bit manipulation
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
