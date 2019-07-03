import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class _3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length < 3) return Integer.MAX_VALUE;
        int ans = nums[0] + nums[1] + nums[2];
        int abs = Integer.MAX_VALUE;
        int len = nums.length;


        for (int i = 0; i < len - 2; i++) {
            ;
            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    if (target - sum < abs) {
                        abs = target - sum;
                        ans = sum;
                    }
                    left++;
                } else {
                    if (sum - target < abs) {
                        abs = sum-target;
                        ans = sum;
                    }
                    right--;
                }
            }
        }
        return ans;

    }
}
