import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int res = 0, tmp = 0;
        int sign = 1;

        for(char c: s.toCharArray()) {
            if(c=='(') {
                stk.push(res);
                stk.push(sign);
                res = 0;
                sign = 1;
            } else if (c==')') {
                res += sign * tmp;
                int prevSign = stk.pop();
                int prevRes = stk.pop();
                res = prevRes + prevSign * res;
                tmp = 0;
            } else if (c=='+') {
                res += sign * tmp;
                tmp = 0;
                sign = 1;
            } else if (c=='-') {
                res += sign * tmp;
                tmp = 0;
                sign = -1;
            } else if (Character.isDigit(c)){
                tmp = 10 * tmp + c-'0';
            }
        }
        if(tmp!=0) {
            res += sign * tmp;
        }
        return res;
    }
}
