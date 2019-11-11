/**
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 * <p>
 * Return the number of closed islands.
 */

public class NumberOfClosedIslands {
    int cnt = 0;

    public int closedIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    boolean[] isClosed = new boolean[]{true};
                    helper(isClosed, grid, i, j, visited);
                    if (isClosed[0]) cnt += 1;
                }
            }
        }
        return cnt;
    }

    public void helper(boolean[] isClosed, int[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        if (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) isClosed[0] = false;

        if (i - 1 >= 0 && grid[i - 1][j] == 0 && !visited[i - 1][j]) helper(isClosed, grid, i - 1, j, visited);
        if (j - 1 >= 0 && grid[i][j - 1] == 0 && !visited[i][j - 1]) helper(isClosed, grid, i, j - 1, visited);
        if (i + 1 <= grid.length - 1 && grid[i + 1][j] == 0 && !visited[i + 1][j])
            helper(isClosed, grid, i + 1, j, visited);
        if (j + 1 <= grid[0].length - 1 && grid[i][j + 1] == 0 && !visited[i][j + 1])
            helper(isClosed, grid, i, j + 1, visited);

    }
}
