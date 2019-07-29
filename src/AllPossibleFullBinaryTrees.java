import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ans = new ArrayList<>();
        if (N == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }
        for (int i = 1; i < N - 1; i += 2) {
            for (TreeNode left : allPossibleFBT(i)) {
                for (TreeNode right : allPossibleFBT(N - 1 - i)) {
                    TreeNode cur = new TreeNode(0);
                    cur.left = left;
                    cur.right = right;
                    ans.add(cur);
                }
            }
        }
        return ans;

    }
}
