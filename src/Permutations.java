import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */

public class Permutations {
//    List<List<Integer>> res = new ArrayList<>();
//
//    public List<List<Integer>> permute(int[] nums) {
//        generatePermutations(nums, new ArrayList<>());
//        return res;
//    }
//
//    public void generatePermutations(int[] nums, List<Integer> tmp) {
//        if (tmp.size() == nums.length) {
//            res.add(new ArrayList<>(tmp));
//            return;
//        }
//        for (int num : nums) {
//            if (tmp.contains(num)) continue;
//            tmp.add(num);
//            generatePermutations(nums, tmp);
//            tmp.remove(tmp.size() - 1);
//        }
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;

        generatePermutation(res, new ArrayList<>(), nums);
        return res;
    }

    public void generatePermutation(List<List<Integer>> res, List<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int num : nums) {
            if (tmp.contains(num)) continue;
            tmp.add(num);
            generatePermutation(res, tmp, nums);
            tmp.remove(tmp.size() - 1);
        }
    }
}
