import java.util.Arrays;

// 179. Largest Number
/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] numsArray = new String[nums.length];
        for(int i=0;i<nums.length;i++) {
            numsArray[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(numsArray, (a,b)-> (b+a).compareTo(a+b));
        if(numsArray[0].charAt(0)=='0') return "0";

        StringBuilder sb = new StringBuilder();

        for(String num:numsArray) {
            sb.append(num);
        }

        return sb.toString();
        
    }
}
