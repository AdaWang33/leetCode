import java.util.LinkedList;
import java.util.Queue;

/**
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 *
 * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
 *
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
 * C_1 is at location (0, 0) (ie. has value grid[0][0])
 * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
 * Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
 *
 */

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // backtracking 属于dfs的普世情况
        // 求最短路径应该首先考虑bfs

        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0]!=0||grid[m-1][n-1]!=0) return -1;
        int cnt = 0;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int i=0, j=0;
        while(!queue.isEmpty()){
            cnt++;
            int num = queue.size();
            for(int tmp=0;tmp<num;tmp++){
                int[] index = queue.poll();
                i = index[0];
                j = index[1];
                if(i==m-1&&j==n-1) return cnt;
                for(int x=i-1;x<=i+1;x++){
                    for(int y=j-1;y<=j+1;y++){
                        if(x>=0&&x<m&&y>=0&&y<n && !visited[x][y] && grid[x][y]==0){
                            queue.offer(new int[]{x, y});
                            visited[x][y] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }
}
