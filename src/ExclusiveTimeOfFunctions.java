import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stk = new Stack<>(); // 存入id
        int[] ans = new int[n];
        int prev = 0;   // 存入最近的startId

        for (String log : logs) {
            String[] temp = log.split(":");
            int id = Integer.parseInt(temp[0]);
            int cur = Integer.parseInt(temp[2]);

            if (temp[1].equals("start")) {
                if (!stk.isEmpty()) {
                    ans[stk.peek()] += cur - prev;
                }
                prev = cur;
                stk.push(id);
            } else {
                ans[stk.pop()] += cur - prev + 1;
                prev = cur + 1;
            }
        }

        return ans;
    }
}
