import java.util.Arrays;
// 1235. Maximum Profit in Job Scheduling
/**
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.
 */

public class MaximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        if(profit.length==1) return endTime[0]>startTime[0]? profit[0]:0;
        
        int[][] arr=new int[startTime.length][3];
        for(int i=0;i<arr.length;i++)
        {
            arr[i][0]=startTime[i];
            arr[i][1]=endTime[i];
            arr[i][2]=profit[i];
        }

        Arrays.sort(arr,(a,b)->a[1]-b[1]); // based on endTime

        int[] dp = new int[profit.length+1]; // one more, so dp[2] can be dp[1] or possibly dp[0] + profit
        for(int i=0; i<profit.length;i++) {
            int j=helper(arr, 0, i, arr[i][0]); // binary search for closest endTime before cur startTime
            dp[i+1] = Math.max(dp[i], dp[j] + arr[i][2]);
        }

        return dp[profit.length];
    }

    private int helper(int[][] arr, int left, int right, int targetTime) {
        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid][1] <= targetTime) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
