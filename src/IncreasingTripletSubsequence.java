/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 *
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: true
 * Example 2:
 *
 * Input: [5,4,3,2,1]
 * Output: false
 */

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
//         if(nums==null||nums.length==0) return false;
//         int[] left = new int[nums.length];
//         int[] right = new int[nums.length];

//         int minLeft = nums[0];
//         int maxRight = nums[nums.length-1];
//         for(int i=0;i<nums.length;i++){
//             minLeft = Math.min(minLeft, nums[i]);
//             left[i] = minLeft;
//         }

//         for(int i=nums.length-1;i>=0;i--){
//             maxRight = Math.max(maxRight, nums[i]);
//             right[i] = maxRight;
//         }

//         for(int i=0;i<nums.length;i++){
//             if(left[i]<nums[i]&&nums[i]<right[i]) return true;
//         }
//         return false;
//     }

        // 从三个里最后一个往前看
        if(nums==null||nums.length==0) return false;
        int low = Integer.MAX_VALUE;
        int high = Integer.MAX_VALUE;
        for(int num:nums){
            if(num<=low) low = num; // update low bar if n is lower than both
            else if(num<=high) high = num; // update high only if higher than low but lower than high
            else return true;
        }
        return false;
    }
}
