import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    List<Integer> delete_list;
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // 其实和直接delete nodes相似，只是要传递par是否delete的信息，以此来更新root列表, 注意return的位置
        delete_list = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        for (int i = 0; i < to_delete.length; i++) {
            delete_list.add(to_delete[i]);
        }
        dfs(root, true);
        return ans;
    }

    public TreeNode dfs(TreeNode root, boolean par_deleted) {
        if (root == null) return null;
        boolean delete = false;
        if (delete_list.contains(root.val)) delete = true;
        if (par_deleted && !delete) ans.add(root);
        root.left = dfs(root.left, delete);
        root.right = dfs(root.right, delete);
        return delete ? null : root;

    }
}
