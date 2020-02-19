public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] sum = new int[board.length+1][board[0].length+1];
        int[][] neighors = new int[board.length][board[0].length];
        for(int i=1;i<sum.length;i++){
            for(int j=1;j<sum[0].length;j++){
                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+board[i-1][j-1];
            }
        }

        for(int i=0;i<neighors.length;i++){
            for(int j=0;j<neighors[0].length;j++){
                int left = j-2;
                int right = j+1;
                int up = i-2;
                int down = i+1;
                left++;
                right++;
                up++;
                down++;
                left = left>=0?left:0;
                right=right<=neighors[0].length?right:neighors[0].length;
                up = up>=0?up:0;
                down = down<=neighors.length?down:neighors.length;
                neighors[i][j] = sum[down][right]-sum[down][left]-sum[up][right]+sum[up][left]-board[i][j];
                // System.out.println(neighors[i][j]);
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==1){
                    if(neighors[i][j]<2) board[i][j]=0;
                    if(neighors[i][j]==2||neighors[i][j]==3) board[i][j]=1;
                    if(neighors[i][j]>3) board[i][j]=0;
                }
                else{
                    if(neighors[i][j]==3) board[i][j]=1;
                }
            }
        }
    }
}
