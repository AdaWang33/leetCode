/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */

public class JumpGameII {
    public int jump(int[] nums) {
        int step_count = 0;
        int last_jump_max = 0;
        int current_jump_max = 0;
        for(int i=0; i<nums.length-1; i++) {
            current_jump_max = Math.max(current_jump_max, i+nums[i]);
            if( i == last_jump_max ) {
                // System.out.println(i);
                // System.out.println(current_jump_max);
                step_count++;
                last_jump_max = current_jump_max;
            }
        }
        return step_count;
    }
}
