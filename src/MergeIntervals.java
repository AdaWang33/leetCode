import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stk = new Stack<>();
        stk.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= stk.peek()[1]) {
                int min = Math.min(stk.peek()[0], intervals[i][0]);
                int max = Math.max(stk.peek()[1], intervals[i][1]);
                int[] newEle = {min, max};
                stk.pop();
                stk.push(newEle);
            } else {
                ans.add(stk.pop());
                stk.push(intervals[i]);
            }
        }
        ans.add(stk.pop());
        return ans.toArray(new int[ans.size()][]);
    }
}
