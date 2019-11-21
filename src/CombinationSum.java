import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        Arrays.sort(candidates);
//        return backtracking(candidates, 0, target, new ArrayList<>(), res);
//        //return res;
//    }
//    public List<List<Integer>> backtracking(int[] candidates, int idx, int target, List<Integer> tmp, List<List<Integer>> res) {
//        if (target == 0) {
//            res.add(new ArrayList<>(tmp));
//            return res;
//        }
//        for (int i = idx; i < candidates.length && candidates[i] <= target; i++) {
//            int num = candidates[i];
//            tmp.add(num);
//            backtracking(candidates, i, target - num, tmp, res);
//            tmp.remove(tmp.size() - 1);
//        }
//        return res;
//    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0) return res;

        Arrays.sort(candidates);
        generateCombinationSum(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void generateCombinationSum(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int remains, int index) {
        if (remains < 0) return;
        if (remains == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            generateCombinationSum(res, tmp, candidates, remains - candidates[i], i);
            tmp.remove(tmp.size() - 1);
        }

    }
}
