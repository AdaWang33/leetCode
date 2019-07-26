import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    // dfs, 用转换为string的方式来遍历，用hashmap的频率来作为决定因素
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        if (root == null) return ans;
        HashMap<String, Integer> map = new HashMap<>();
        hashString(root, map, ans);
        return ans;
    }

    public String hashString(TreeNode root, HashMap<String, Integer> map, List<TreeNode> ans) {
        if (root == null) return "#";
        String cur = root.val + "," + hashString(root.left, map, ans) + "," + hashString(root.right, map, ans);
        int frequency = map.getOrDefault(cur, 0);
        if (frequency == 1) ans.add(root);
        map.put(cur, frequency + 1);
        return cur;
    }
}
