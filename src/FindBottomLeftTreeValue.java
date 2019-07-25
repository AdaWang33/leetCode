import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindBottomLeftTreeValue {
    int maxDepth = Integer.MIN_VALUE;
    int maxVal = Integer.MIN_VALUE;

    public int findBottomLeftValue(TreeNode root) {
        // 最左边的记录深度和val
        int depth = 1;
        findByDepth(root, depth);
        return maxVal;
    }

    public void findByDepth(TreeNode root, int depth) {
        if (root == null) return;
        if (maxDepth < depth) {
            maxDepth = depth;
            maxVal = root.val;
        }
        findByDepth(root.left, depth + 1);
        findByDepth(root.right, depth + 1);
    }
}
