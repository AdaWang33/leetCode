/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int res = dpMax[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            dpMax[i] = Math.max(Math.max(dpMax[i - 1] * num, num), dpMin[i - 1] * num);
            dpMin[i] = Math.min(Math.min(dpMax[i - 1] * num, num), dpMin[i - 1] * num);
            res = Math.max(res, dpMax[i]);
            // System.out.println(i + "," + dpMax[i]);
        }
        return res;
    }
}
