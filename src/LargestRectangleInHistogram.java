import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        Stack<Integer> idx = new Stack<>();
        idx.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (idx.peek() != -1) {
                if (heights[idx.peek()] > heights[i]) {
                    int top = idx.pop();
                    max = Math.max(max, heights[top] * (i - 1 - idx.peek()));
                } else {
                    break;
                }
            }
            idx.push(i);
        }

        while (idx.peek() != -1) {
            int top = idx.pop();
            max = Math.max(max, heights[top]*(heights.length-1-idx.peek()));
        }
        return max;
    }
}
