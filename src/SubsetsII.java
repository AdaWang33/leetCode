import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;

        Arrays.sort(nums);
        generateSubWithDup(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void generateSubWithDup(List<List<Integer>> res, List<Integer> tmp, int[] nums, int index) {
        res.add(new ArrayList<>(tmp));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            tmp.add(nums[i]);
            generateSubWithDup(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

}
