import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // create hashmap, mapping from list element to its index
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for(int i = 0; i< nums.length; i++){
            int complement = target - nums[i];
            // if list contains complement and is not the same element
            if(map.containsKey(complement) && i != map.get(complement)) return(new int[] {i, map.get(complement)});
        }
        throw new IllegalArgumentException("No sum solution");
    }
}
