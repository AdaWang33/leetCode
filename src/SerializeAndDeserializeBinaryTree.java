import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "$";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayDeque<String> deque = new ArrayDeque<>(Arrays.asList(data.split(",")));
        TreeNode root = helper(deque);
        return root;
    }

    public TreeNode helper(ArrayDeque<String> deque) {
        String first = deque.removeFirst();
        if (first.equals("$")) return null;
        int rootVal = Integer.valueOf(first);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(deque);
        root.right = helper(deque);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
