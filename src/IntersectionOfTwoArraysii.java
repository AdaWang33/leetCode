import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */

public class IntersectionOfTwoArraysii {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> resList = new ArrayList<>();

        for(int i=0;i<nums1.length;i++) {
            int cnt = map.getOrDefault(nums1[i], 0);
            map.put(nums1[i], ++cnt);
        }

        for(int i=0;i<nums2.length;i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i])>0) {
                resList.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }

        int[] res = new int[resList.size()];
        for(int i=0;i<res.length;i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
