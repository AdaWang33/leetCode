import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */

public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "$";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayDeque<String> tmp = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return buildString(tmp);
    }

    public TreeNode buildString(ArrayDeque<String> tmp) {
        String first = tmp.removeFirst();
        if (first.equals("$")) return null;
        int val = Integer.valueOf(first);
        TreeNode root = new TreeNode(val);
        root.left = buildString(tmp);
        root.right = buildString(tmp);
        return root;
    }
}
