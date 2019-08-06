import java.util.Stack;

public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        int slots = 1;

        for (String ele : preorder.split(",")) {
            if (--slots < 0) return false;
            if (!ele.equals("#")) slots += 2;
        }
        return slots == 0;
    }
}
