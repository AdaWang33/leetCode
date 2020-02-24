import java.util.*;

public class RandomPickIndex {
    Map<Integer, List<Integer>> map = new HashMap<>();
    public RandomPickIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            List<Integer> list = map.getOrDefault(nums[i],new ArrayList<>());
            list.add(i);
            map.put(nums[i],list);
        }
    }

    public int pick(int target) {
        List<Integer> idxs = map.get(target);
        int len = idxs.size();

        int index = new Random().nextInt(len);
        return idxs.get(index);

    }
}
