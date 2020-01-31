import java.util.PriorityQueue;

public class PathWithMaximumMinimumValue {
    public int maximumMinimumPath(int[][] A) {
        // bfs+pq
        final int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        boolean[][] visited = new boolean[A.length][A[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(b[0],a[0]));

        pq.add(new int[]{A[0][0], 0, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int i = cur[1];
            int j = cur[2];
            visited[i][j] = true;

            if(i==A.length-1&&j==A[0].length-1) return cur[0];

            for(int[] pair:dir){
                int x = i+pair[0];
                int y = j+pair[1];
                if(x<0||y<0||x>A.length-1||y>A[0].length-1|| visited[x][y]) continue;
                pq.offer(new int[]{Math.min(cur[0],A[x][y]), x, y});
            }
        }
        return -1;
    }
}
