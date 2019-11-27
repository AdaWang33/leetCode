/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class MinimumPathSum {
//    public int minPathSum(int[][] grid) {
//        int[] minimum = {Integer.MAX_VALUE};
//        minPath(grid, 0, 0, 0, minimum);
//        return minimum[0];
//    }
//
//    public void minPath(int[][] grid, int i, int j, int prevSum, int[] minimum) {
////        System.out.println("i:" + i + ";" + "j:" + j);
//        if (i > grid.length - 1 || j > grid[0].length - 1) return;
//
//        prevSum += grid[i][j];
//        if (i == grid.length - 1 && j == grid[0].length - 1) {
//            minimum[0] = Math.min(minimum[0], prevSum);
//            return;
//        }
//        minPath(grid, i + 1, j, prevSum, minimum);
//        minPath(grid, i, j + 1, prevSum, minimum);
//    }

    public int minPathSum(int[][] grid) {
        // try dp
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

}
