public class MaximumDepthOfN_aryTree {
    int maxD = Integer.MIN_VALUE;

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 1;
        findDepth(root, depth);
        return maxD;
    }

    public void findDepth(Node root, int depth) {
        maxD = Math.max(maxD, depth);
        for (Node child : root.children) {
            findDepth(child, depth + 1);
        }
    }
}
