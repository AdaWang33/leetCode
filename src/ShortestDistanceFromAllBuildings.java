class Solution {
    // 317 hard
    //count sum of distance from 0 to all building
    int[][] distance;
    //count how many building each '0' can be reached
    int[][] reach ;
    int[][] dirs=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        int m  = grid.length, n = grid[0].length;
        distance = new int[m][n];
        reach = new int[m][n];
        int buildingNum = 0;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if(grid[i][j] == 1){
                    buildingNum++;
                    bfs(grid,i,j);
                }
            }
        }
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;

    }
    private void bfs(int[][] grid,int x, int y){
        int m  = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{x,y});
        boolean[][] visited = new boolean[m][n];
        int level = 1;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0;i < size;i++){
                int[] curr = q.poll();
                for (int[] dir:dirs){
                    int x1 = dir[0]+curr[0];
                    int y1 = dir[1]+curr[1];
                    if(x1 < 0 || x1 >= m || y1 < 0 || y1 >= n) continue;
                    if(grid[x1][y1] != 0 || visited[x1][y1]) continue;
                    //find next 0: level++;
                    distance[x1][y1] += level;
                    reach[x1][y1]++;
                    visited[x1][y1] = true;
                    q.offer(new int[]{x1,y1});
                }
            }
            level++;
        }  
    }
    //     int[][] distance;
    //     int[][] reach;
    //     int buildCount = 0;
    //     int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};

    // public int shortestDistance(int[][] grid) {
    //     if(grid==null || grid[0].length==0) return 0; // ?
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     distance = new int[m][n];
    //     reach = new int[m][n];
    //     int res = Integer.MAX_VALUE;

    //     for(int i=0; i<m; i++) { // start from type 1 building, calculate distance to each type 0 building
    //         for (int j=0;j<n;j++) {
    //             if(grid[i][j]==1) {
    //                 buildCount++;
    //                 bfs(i, j, grid);
    //             }
    //         }
    //     }

    //     for(int i=0; i<m; i++) { // now total distance for each type 0 building is calculated, check if all type 1 building is accessible & find minimal total distance
    //         for (int j=0;j<n;j++) {
    //             if(grid[i][j]==0 || reach[i][j]==buildCount) {
    //                 res = Math.min(res, distance[i][j]);
    //             }
    //         }
    //     }
    //     return res == Integer.MAX_VALUE ? -1 : res;
    // }

    // private void bfs(int x, int y, int[][] grid) {
    //     boolean[][] visited = new boolean[grid.length][grid[0].length];
    //     Queue<int[]> queue = new LinkedList<>();
    //     int dist = 1;

    //     queue.offer(new int[]{x,y});
    //     while(!queue.isEmpty()) {
    //         int curSize = queue.size();
    //         for(int k=0;k<curSize;k++) {
    //             int[] curLoc = queue.poll();
    //             for (int[] dir:dirs) {
    //                 int nextX = dir[0] + curLoc[0];
    //                 int nextY = dir[1] + curLoc[1];
    //                 if (nextX<0 || nextX>grid.length-1 || nextY<0 || nextY>grid[0].length-1) return;
    //                 if( grid[nextX][nextY]!=0 || visited[nextX][nextY])  return;
    //                 distance[nextX][nextY]+=dist;
    //                 reach[nextX][nextY]++;
    //                 visited[nextX][nextY] = true;
    //                 queue.offer(new int[]{nextX, nextY});
    //             }
    //         }
    //         dist++;
    //     }
    // }
}