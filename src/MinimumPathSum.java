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


}
