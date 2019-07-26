import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        List<Integer> lefts = new ArrayList<>();
        return widthByThisNode(root, 1, 0, lefts);
    }

    public int widthByThisNode(TreeNode root, int idx, int d, List<Integer> lefts) {
        if (root == null) return 0;
        if (d >= lefts.size()) {    // 定锚
            lefts.add(idx);
        }
        return Math.max(idx + 1 - lefts.get(d), Math.max(widthByThisNode(root.left, 2 * idx, d + 1, lefts), widthByThisNode(root.right, 2 * idx + 1, d + 1, lefts)));
    }
}
