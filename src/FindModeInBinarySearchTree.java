import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindModeInBinarySearchTree {
    HashMap<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {
        List<Integer> lans = new ArrayList<>();
        buildHashMap(root);
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                lans.add(key);
            }
        }
        int[] ans = new int[lans.size()];
        for (int i = 0; i < lans.size(); i++) {
            ans[i] = lans.get(i);
        }
        return ans;
    }

    public void buildHashMap(TreeNode root) {
        if (root == null) return;
        int val = root.val;
        int cnt = map.getOrDefault(val, 0) + 1;
        max = Math.max(max, cnt);
        map.put(val, cnt);
        buildHashMap(root.left);
        buildHashMap(root.right);
    }
}
