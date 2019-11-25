/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 */

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    ans[i][j] = 1;
                } else {
                    ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
                }
            }
        }
        return ans[m - 1][n - 1];
    }
}
