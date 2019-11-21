import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0) return res;
        Arrays.sort(candidates);
        generateCombinationWithDup(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void generateCombinationWithDup(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int remains, int index) {
        if (remains < 0) return;
        if (remains == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            tmp.add(candidates[i]);
            generateCombinationWithDup(res, tmp, candidates, remains - candidates[i], i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
