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
    List<List<Integer>> res;
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums.length == 0) return res;
        
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        
        helper(new ArrayList<>(), nums);
        return res;
    }

    private void helper(List<Integer> temp, int[] nums) {
        if (temp.size()==nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(visited[i] || (i>0 && nums[i]==nums[i-1] && !visited[i-1])) {
                continue;
            }
            temp.add(nums[i]);
            visited[i] = true;
            helper(temp, nums);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }
}