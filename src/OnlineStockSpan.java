import java.util.Stack;

public class OnlineStockSpan {
    Stack<int[]> span;

    public StockSpanner() {
        span = new Stack<>();
    }

    public int next(int price) {
        int curSpan = 1;
        while (!span.isEmpty() && span.peek()[0] <= price) {
            curSpan += span.pop()[1];
        }
        span.push(new int[]{price, curSpan});
        return curSpan;
    }
}
