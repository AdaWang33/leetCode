public class ConvertBSTToGreaterTree {
    // BST： 左小右大的原则千万要用上！
    // 右边大，把右边的和倾倒过来
    // 左边小，把自己的值倾倒过去
    // 不能是基本数据类型！

    public TreeNode convertBST(TreeNode root) {
        if(root==null) return root;
        changeValue(root, new int[1] );
        return root;
    }

    public void changeValue(TreeNode root, int[] sum) {
        if (root == null) return;
        changeValue(root.right, sum);
        root.val += sum[0];
        sum[0] = root.val;
        changeValue(root.left, sum);
    }
}

