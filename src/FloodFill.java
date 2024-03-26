/**
 * 733. Flood Fill
 * 
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.
 */

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int[][] dict = {{-1,0},{1,0},{0,-1},{0,1}};
        int originColor = image[sr][sc];
        
        dfs(image, sr, sc, originColor, color, visited, dict);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int originColor, int color, boolean[][] visited, int[][] dict) {
        image[sr][sc] = color;
        visited[sr][sc] = true;

        for(int[] dic: dict) {
            int curSr = sr+dic[0];
            int curSc = sc+dic[1];
            if(curSr<0 || curSr>=image.length || curSc<0 || curSc>=image[0].length) continue;
            if(image[curSr][curSc]!= originColor || visited[curSr][curSc]) continue;
            bfs(image, curSr, curSc, originColor, color, visited, dict);
        }
        
    }
}
