import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MostFrequentSubtreeSum {
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxCnt = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {
        findSum(root);
        List<Integer> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxCnt) {
                ans.add(key);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public int findSum(TreeNode root) {
        if (root == null) return 0;
        int sum = root.val + findSum(root.left) + findSum(root.right);
        int cnt = map.getOrDefault(sum, 0) + 1;
        maxCnt = Math.max(maxCnt, cnt);
        map.put(sum, cnt);
        return sum;
    }
}
