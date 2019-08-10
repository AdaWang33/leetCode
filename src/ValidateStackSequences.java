import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int pushId = 0;

        for (int popVal : popped) {
            if (!stk.isEmpty() && stk.peek() == popVal) {
                stk.pop();
                continue;
            }
            while (pushId < pushed.length && pushed[pushId] != popVal) {
                stk.push(pushed[pushId]);
                pushId++;
            }
            if (pushId >= pushed.length) return false;
            pushId++;
        }
        return true;
    }
}
