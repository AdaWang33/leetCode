import java.util.HashMap;

public class SecondMinimumNodeInABinaryTree {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int findSecondMinimumValue(TreeNode root) {
        inorderTraverse(root);
        int Min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        for (int val : map.keySet()) {
            if (val < Min) {
                Min = val;
            }
        }
        map.remove(Min, map.get(Min));
        if (map.size() != 0) {
            for (int val : map.keySet()) {
                if (val < secMin) {
                    secMin = val;
                }
            }
            return secMin;
        } else {
            return -1;
        }
    }

    public void inorderTraverse(TreeNode root) {
        if (root == null) return;
        if (map.getOrDefault(root.val, 0) == 0) {
            map.put(root.val, 1);
        }
        inorderTraverse(root.left);
        inorderTraverse(root.right);
    }
}
