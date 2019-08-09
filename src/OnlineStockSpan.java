import java.util.Stack;

public class OnlineStockSpan {
    Stack<Integer> prices, span;

    public StockSpanner() {
        prices = new Stack<>();
        span = new Stack<>();
    }

    public int next(int price) {
        int curSpan = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            curSpan += span.pop();
        }
        prices.push(price);
        span.push(curSpan);
        return curSpan;
    }
}
