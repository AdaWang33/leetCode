import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int length = nums.length;
        if(length==1) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        map.put(0,-1);

        for(int i=0;i<length;i++) {
            cnt += nums[i]==0 ? -1 : 1;
            if (map.containsKey(cnt)) {
                res = Math.max(res, i-map.get(cnt));
            } else {
                map.put(cnt, i);
            }
        
        }
        return res;
        
    }
}
