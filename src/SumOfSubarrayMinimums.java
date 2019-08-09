import java.util.Stack;

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] A) {
        // left[i]+1: 表示以当前idx为最后一个，且为最小值的array的个数
        // right[i]+1: 表示以当前idx为第一个，且为最小值的array的个数
        // 两者相乘，得到以A[idx]数为最小值的所有情况数，再乘上自己的值，就得到idx的结果

        int ans = 0;
        Stack<int[]> left = new Stack<>();
        Stack<int[]> right = new Stack<>();
        int[] leftCnt = new int[A.length];
        int[] rightCnt = new int[A.length];
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < A.length; i++) {
            int cnt = 1;
            while (!left.isEmpty() && left.peek()[0] > A[i]) {
                cnt += left.pop()[1];
            }
            left.push(new int[]{A[i], cnt});
            leftCnt[i] = cnt;
        }

        for (int j = A.length - 1; j >= 0; j--) {
            int cnt = 1;
            while (!right.isEmpty() && right.peek()[0] >= A[j]) {
                cnt += right.pop()[1];
            }
            right.push(new int[]{A[j], cnt});
            rightCnt[j] = cnt;
        }

        for (int i = 0; i < A.length; i++) {
            ans = (ans + A[i] * leftCnt[i] * rightCnt[i]) % mod;
        }
        return ans;
    }
}
