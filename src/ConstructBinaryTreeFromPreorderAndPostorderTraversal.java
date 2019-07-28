import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre.length==0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if(pre.length==1) return root;

        int idxLeft = 0;
        int idxRight = 0;
        for(int i =0; i< post.length; i++){
            if(post[i] == pre[1]) idxLeft = i+1;
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre,1,idxLeft+1), Arrays.copyOfRange(post,0, idxLeft));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre,idxLeft+1, pre.length),Arrays.copyOfRange(post, idxLeft, pre.length-1));
        return root;
    }
}


/**
 * public TreeNode constructFromPrePost(int[] pre, int[] post) {
 *         return findByIndex(0, pre.length - 1, 0, post.length - 1, pre, post);
 *     }
 *
 *     public TreeNode findByIndex(int preStart, int preEnd, int postStart, int postEnd, int[] pre, int[] post) {
 *         if (preStart > preEnd || postEnd < postStart) return null;
 *         if (preStart == preEnd || postStart == postEnd) return new TreeNode(pre[preStart]);
 *
 *         TreeNode root = new TreeNode(pre[preStart]);
 *         int leftVal = pre[preStart + 1];
 *         int rightVal = post[postEnd - 1];
 *         int idxLeft = 0;
 *         int idxRight = 0;
 *         for (int i = postStart; i <= postEnd; i++) {
 *             if (leftVal == post[i])
 *                 idxLeft = i;
 *         }
 *         for (int i = preStart; i <= preEnd; i++) {
 *             if (rightVal == pre[i])
 *                 idxRight = i;
 *         }
 *         root.left = findByIndex(preStart + 1, idxLeft - postStart + preStart + 1, postStart, idxLeft, pre, post);
 *         root.right = findByIndex(idxRight, preEnd, idxRight - preEnd + postEnd - 1, postEnd - 1, pre, post);
 *         return root;
 *     }
 */