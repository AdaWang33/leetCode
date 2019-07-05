import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */

public class _4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();

        int i = 0;
        int sum = 0;
        calculate(nums, i, sum, target, temp, ans);
        return ans;

    }

    private void calculate(int[] nums, int i, int sum, int target, List<Integer> temp, List<List<Integer>> ans) {

        if (temp.size() == 4) {
            if (sum == target) ans.add(temp);
            sum = 0;
            return;
        }
        while (i < nums.length - 1) {

            temp.add(nums[i]);
            sum += nums[i];
            calculate(nums, i + 1, sum, target, temp, ans);

        }
    }
}
