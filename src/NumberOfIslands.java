/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int cnt = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    cnt++;
                    findNeighbor1(grid, i, j, visited);
                }
            }
        }
        return cnt;
    }

    public void findNeighbor1(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || visited[i][j] == true || grid[i][j] != '1')
            return;
        visited[i][j] = true;
        findNeighbor1(grid, i - 1, j, visited);
        findNeighbor1(grid, i, j - 1, visited);
        findNeighbor1(grid, i + 1, j, visited);
        findNeighbor1(grid, i, j + 1, visited);
    }
}
