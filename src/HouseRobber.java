/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] rob = new int[nums.length]; // max money we can get if we rob this house
        int[] notRob = new int[nums.length]; // max money we can get if we don't rob this house
        rob[0] = nums[0];
        notRob[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            rob[i] = notRob[i - 1] + nums[i];
            notRob[i] = Math.max(rob[i - 1], notRob[i - 1]);
        }
        return Math.max(rob[nums.length - 1], notRob[nums.length - 1]);
    }
}
