import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementii {
    public List<Integer> majorityElement(int[] nums) {
        int cnt = nums.length/3;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int num: nums) {
            int curCnt = map.getOrDefault(num,0);
            map.put(num, ++curCnt);
            if(curCnt>cnt && res.indexOf(num)==-1) {
                res.add(num);
            }
        }

        return res;
    }
}
