import java.util.Arrays;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 */

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != (i + 1)) goFindRightPlace(nums[i], nums);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        // otherwise return next
        int maximum = 0;
        for (int ele : nums) maximum = Math.max(maximum, ele);
        return maximum + 1;
    }

    public void goFindRightPlace(int ele, int[] nums) {
        int next_ele = nums[ele - 1];
        nums[ele - 1] = ele;

        if (next_ele > 0 && next_ele <= nums.length && next_ele != nums[next_ele-1]) goFindRightPlace(next_ele, nums);
    }

}
