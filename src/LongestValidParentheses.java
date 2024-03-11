import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int res = 0;
        if(s.length()<2) return res;

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)==')') {
                if(i>0 && s.charAt(i-1)=='(') { // check if previous c matches
                    dp[i] = i>1 ? dp[i-2]+2:2;
                } else { // check if previous has closed, track back to the left half
                    if(i>0 && dp[i-1]>0 && i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='(') {
                        dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2 >=0 && dp[i-dp[i-1]-2]>0 ? dp[i-dp[i-1]-2] :0);
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }

        return res;

        // int longest = 0;
        // Stack<Integer> stk = new Stack<>();
        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == '(') {
        //         stk.push(i);
        //     } else {
        //         if (!stk.isEmpty() && s.charAt(stk.peek()) == '(') {
        //             stk.pop();
        //         } else {
        //             stk.push(i);
        //         }
        //     }
        // }
        // if (stk.isEmpty()) return s.length();

        // int b = stk.peek();
        // longest = s.length() - stk.pop() - 1;
        // while (!stk.isEmpty()) {
        //     int a = stk.pop();
        //     longest = Math.max(longest, b - a - 1);
        //     b = a;
        // }
        // longest = Math.max(longest, b);

        // return longest;
    }
}
