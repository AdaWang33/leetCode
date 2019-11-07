/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        return findInRotate(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int p, int q, int target) {
        if (p > q) return -1;

        int m = (p + q) / 2;
        if (target < nums[m]) return binarySearch(nums, p, m - 1, target);
        else if (target == nums[m]) return m;
        else return binarySearch(nums, m + 1, q, target);
    }

    public int findInRotate(int[] nums, int p, int q, int target) {
        if (p == q && nums[p] != target) return -1;
        int m = (p + q) / 2;

        boolean left = nums[p] <= nums[m];  // size为零或者确实顺
        if (left) {
            if (nums[p] <= target && target <= nums[m]) {
                return binarySearch(nums, p, m, target);
            } else {
                return findInRotate(nums, m + 1, q, target);
            }
        } else {
            if (nums[m + 1] <= target && target <= nums[q]) {
                return binarySearch(nums, m + 1, q, target);
            } else {
                return findInRotate(nums, p, m, target);
            }
        }

    }

}
