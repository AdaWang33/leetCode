import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeCameras {
    int cnt = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) == 0 ? 1 : 0) + cnt;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 2;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            cnt++;
            return 1;
        }
        if (left == 1 || right == 1) {
            return 2;
        }
        return 0;
    }
}
