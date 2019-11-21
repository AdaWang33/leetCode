import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        generatePermutationsWithDup(res, new ArrayList<>(), nums, used);
        return res;
    }

    public void generatePermutationsWithDup(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            used[i] = true;
            tmp.add(nums[i]);
            generatePermutationsWithDup(res, tmp, nums, used);
            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
