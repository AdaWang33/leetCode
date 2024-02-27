import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    // array with order: two pointer, or slide window
    // array w/o order: sums[i] (accumulative), or hashmap (especially sum)
    public int subarraySum(int[] nums, int k) {
        int cnt=0;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)) cnt+=map.get(sum-k);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}
