/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */

public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int left = findFirstInArray(nums, target);
        int right = findLastInArray(nums, target);
        return new int[]{left, right};
    }
    public int findFirstInArray(int[] nums, int target) {
        int p = 0;
        int q = nums.length - 1;
        while (p < q-1) {
            int m = p + (q - p) / 2;
            if (nums[m] == target) q = m;
            else if (nums[m] < target) p = m + 1;
            else q = m - 1;
        }
        if (nums[p]==target) return p;
        if (nums[q] == target) return q;
        return -1;
    }

    public int findLastInArray(int[] nums, int target) {
        int p = 0;
        int q = nums.length - 1;
        while (p < q-1) {
            int m = p + (q - p) / 2;
            if (nums[m] == target) p = m;
            else if (nums[m] < target) p = m + 1;
            else q = m - 1;
        }
        if (nums[q] == target) return q;
        if (nums[p] == target) return p;
        return -1;
    }
}
