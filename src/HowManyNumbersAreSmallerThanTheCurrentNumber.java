import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 * Example 2:
 *
 * Input: nums = [6,5,4,8]
 * Output: [2,1,0,3]
 * Example 3:
 *
 * Input: nums = [7,7,7,7]
 * Output: [0,0,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        for(int i=0;i<sorted.length;i++){
            if(!map.containsKey(sorted[i])) map.put(sorted[i], i);
        }

        for(int i=0;i<nums.length;i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;


//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
//            if(nums[a]!=nums[b]) return nums[a]-nums[b];
//            else return a-b;
//        });
//        for(int i = 0;i<nums.length;i++){
//            pq.offer(i);
//        }
//
//        int prev = 0;
//        int cnt = 0;
//        int prevIndex = 0;
//        int[] res = new int[nums.length];
//        while(!pq.isEmpty()){
//            int curr = pq.poll();
//            if(nums[prev]==nums[curr]){
//                res[curr] = prevIndex;
//            }else{
//                res[curr] = cnt;
//                prevIndex = cnt;
//            }
//            prev = curr;
//            cnt++;
//        }
//
//        return res;

    }
}
