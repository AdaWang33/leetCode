public class SubtreeOfAnotherTree {
    //  直接再比较两个tree
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        boolean thisCompare = compareNode(s,t);
        boolean leftCompare = isSubtree(s.left, t);
        boolean rightCompare = isSubtree(s.right, t);
        return thisCompare || leftCompare || rightCompare;
    }


    public boolean compareNode(TreeNode cur, TreeNode t) {
        if (cur == null && t == null) return true;
        if ((cur == null && t != null) || (cur != null && t == null)) return false;
        return cur.val == t.val && compareNode(cur.left, t.left) && compareNode(cur.right, t.right);
    }
}
