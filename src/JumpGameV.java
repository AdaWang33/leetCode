/**
 * Given an array of integers arr and an integer d. In one step you can jump from index i to index:
 *
 * i + x where: i + x < arr.length and 0 < x <= d.
 * i - x where: i - x >= 0 and 0 < x <= d.
 * In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k] for all indices k between i and j (More formally min(i, j) < k < max(i, j)).
 *
 * You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.
 *
 * Notice that you can not jump outside of the array at any time.
 */
public class JumpGameV {
    int[] dp;
    public int maxJumps(int[] arr, int d) {
        int res = 0;
        dp = new int[arr.length];
        for(int i=0;i<dp.length;i++) dp[i] = -1;
        for(int i=0;i<dp.length;i++){
            res = Math.max(helper(arr, i, d),res);
        }
        return res;
    }

    public int helper(int[] arr, int i, int d){
        if(i<0||i>arr.length-1) return 0;
        if(dp[i]!=-1) return dp[i];

        int curRes = 0;
        for(int j = 1; j <= d; j++) {
            if(i + j == arr.length) break;
            if(arr[i] > arr[i + j]) curRes = Math.max(curRes, helper(arr, i + j, d));
            else break;
        }
        for(int j = 1; j <= d; j++) {
            if(i - j == -1) break;
            if(arr[i] > arr[i - j]) curRes = Math.max(curRes, helper(arr, i - j, d));
            else break;
        }
        dp[i] = curRes+1;
        return dp[i];
    }

}
