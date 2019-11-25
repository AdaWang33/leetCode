/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 */

public class JumpGame {
//    public boolean canJump(int[] nums) {
//        // greedy algorithm: Looking from the start and selecting the locally optimum in the hope of reaching global optimum
//        int farest = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (farest < i) return false;
//            farest = Math.max(i + nums[i], farest);
//        }
//        return true;
//    }

    public boolean canJump(int[] nums) {
        // Dynamic Programming: Looking from the end and at each point ahead checking the best possible way to reach the end
        boolean[] route = new boolean[nums.length];
        route[route.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                if (route[i + j] == true) {
                    route[i] = true;
                    break;
                }
            }
        }

        return route[0];
    }
}
