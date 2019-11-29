import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            int cnt = map.getOrDefault(num, 0);
//            map.put(num, cnt + 1);
//            if (cnt + 1 > nums.length / 2) return num;
//        }
//        return nums[0];
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
