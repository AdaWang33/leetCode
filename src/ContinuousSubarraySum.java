import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * Example 2:
 *
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 *
 *
 * Note:
 *
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        /*
         *  Why is indexOf failing to find the object?
         * 
         *  It should be Integer[] not int[] in order to make it work.
         *  Integer[] A = {3,8,2,5,1,4,7,9};
         *  final int i = Arrays.asList(A).indexOf(3);
         */
        if (nums.length<2) {
            return false;
        }
        
        int sum = 0;
        List<Integer> rest = new ArrayList<>();
        rest.add(0);
        for (int i=0;i<nums.length;i++) {
            sum += nums[i];
            int curRest = sum % k;
            rest.add(curRest);
            if(rest.indexOf(curRest)!=-1 && rest.indexOf(curRest)<i){
                return true;
            }
        }
        return false;

        /* previous approach
         * 
            if((nums==null||nums.length==0 && k!=0)) return false;

            int[] sum = new int[nums.length+1];
            for(int i=1;i<sum.length;i++) sum[i] = sum[i-1]+nums[i-1];

            for(int i=0;i<=nums.length-2;i++){
                for(int j=i+1;j<nums.length;j++){
                    if((k==0 && sum[j+1]-sum[i]==0)||(k!=0 && (sum[j+1]-sum[i])%k==0)) return true;
                }
            }
            return false;
         */

    }
}
