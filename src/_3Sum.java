import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], i);
        }

        for(int i=0;i<nums.length-2;i++) {
            if (i>0 && nums[i-1]==nums[i]) {
                continue;
            }
            sum = -nums[i];
            for (int j=i+1; j<nums.length-1; j++) {
                if (j>i+1 && nums[j-1]==nums[j]) {
                    continue;
                }
                int target = sum-nums[j];
                if (map.containsKey(target) && map.get(target)>j) {
                    res.add(Arrays.asList(nums[i], nums[j], target));
                }
            }
        }        
        return res;
        
        // // doesn't need to be a fix-sized object
        // //List<List<Integer>> result = new ArrayList<Integer>();
        // List<List<Integer>> result = new ArrayList<>();
        // Arrays.sort(nums);
        // int len = nums.length;
        // if (len == 0 || len < 3) return result;
        // for (int i = 0; i < len - 2; i++) {
        //     if (i >0 && nums[i] == nums[i - 1]) continue;
        //     int remains = -nums[i];
        //     int left = i + 1;
        //     int right = len - 1;
        //     while (left < right) {
        //         if (nums[left] + nums[right] == remains) {
        //             result.add(Arrays.asList(nums[i], nums[left], nums[right]));
        //             while (left < right && nums[left] == nums[left + 1]) {
        //                 left++;
        //             }
        //             while (left < right && nums[right] == nums[right - 1]) {
        //                 right--;
        //             }
        //             left++;
        //             right--;
        //         } else if (nums[left] + nums[right] < remains) {
        //             left++;
        //         } else {
        //             right--;
        //         }
        //     }
        // }
        // return result;
    }
}
