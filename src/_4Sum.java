import java.util.ArrayList;
import java.util.Arrays;
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
        // 接着用两个循环加上两个指针，循环比递归效率高
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums.length < 4) return ans;

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + 3 * nums[nums.length - 1] < target) continue;
            if (4 * nums[i] > target) break;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + 2 * nums[nums.length - 1] < target) continue;
                if (nums[i] + 3 * nums[j] > target) break;

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        if(left == j+1 || nums[left]!=nums[left-1]) {
                            List<Integer> temp = new ArrayList<Integer>(4);
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[left]);
                            temp.add(nums[right]);
                            ans.add(temp);
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return ans;

    }
}