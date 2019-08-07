import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // We use a stack to keep a decreasing sub-sequence,
        // whenever we see a number x greater than stack.peek()
        // we pop all elements less than x and for all the popped ones
        // their next greater element is x

        int[] ans = new int[nums1.length];
        Stack<Integer> stk = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!stk.isEmpty() && stk.peek() < num) {
                map.put(stk.pop(), num);
            }
            stk.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
