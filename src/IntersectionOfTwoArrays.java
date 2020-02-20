import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0) return new int[]{};

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int num:nums1) set1.add(num);
        for(int num:nums2) set2.add(num);

        if(set1.size()<set2.size()) return helper(set1, set2);
        else return helper(set2, set1);
    }

    public int[] helper(Set<Integer> set1, Set<Integer> set2){
        int[] res = new int[set1.size()];
        int idx = 0;
        for(int num:set1){
            if(set2.contains(num)) res[idx++]=num;
        }
        return Arrays.copyOf(res, idx);
    }
//         List<Integer> res = new ArrayList<>();

//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         Map<Integer, Boolean> map = new HashMap<>();

//         for(int i=0;i<nums1.length;i++){
//             if(i>0 && nums1[i]==nums1[i-1]) continue;
//             map.put(nums1[i],true);
//         }

//         for(int i=0;i<nums2.length;i++){
//             if(i>0 && nums2[i]==nums2[i-1]) continue;
//             if(map.getOrDefault(nums2[i],false)) res.add(nums2[i]);
//         }

//         int[] ans = new int[res.size()];
//         for(int i=0;i<res.size();i++){
//             ans[i] = res.get(i);
//         }
//         return ans;
//    }
}
