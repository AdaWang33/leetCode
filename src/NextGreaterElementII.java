import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stk = new Stack<>();

        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= nums[i % nums.length]) {
                stk.pop();
            }
            ans[i % nums.length] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[i % nums.length]);
        }
        return ans;
    }
}
