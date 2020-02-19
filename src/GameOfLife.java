public class GameOfLife {
    public void gameOfLife(int[][] board) {
        // 0: dead
        // 1: live
        // 第一位保存现在状态，第二位（高位）保存变化后状态，默认为0
        // 00<-00: 不用考虑
        // 10<-00
        // 01<-01： 不用考虑
        // 11<-01
        if(board==null||board.length==0||board[0].length==0) return;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int cnt = helper(board, i, j);
                if(board[i][j]==1 && (cnt==2||cnt==3)) board[i][j]=3;
                if(board[i][j]==0 && cnt==3) board[i][j]=2;
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]>>=1; // 右移一位得到现在状态
            }
        }
    }

    public int helper(int[][] board, int m, int n){
        int res = 0;
        for(int i=Math.max(m-1, 0);i<=Math.min(m+1,board.length-1);i++){
            for(int j=Math.max(n-1,0);j<=Math.min(n+1, board[0].length-1);j++){
                if(i==m&&j==n) continue;
                res+=board[i][j]&1;
            }
        }
        return res;
    }


    // 常规做法：注意sum[]转到neighbor[]需要注意边界，++,边界
//    public void gameOfLife(int[][] board) {
//        int[][] sum = new int[board.length+1][board[0].length+1];
//        int[][] neighors = new int[board.length][board[0].length];
//        for(int i=1;i<sum.length;i++){
//            for(int j=1;j<sum[0].length;j++){
//                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+board[i-1][j-1];
//            }
//        }
//
//        for(int i=0;i<neighors.length;i++){
//            for(int j=0;j<neighors[0].length;j++){
//                int left = j-2;
//                int right = j+1;
//                int up = i-2;
//                int down = i+1;
//                left++;
//                right++;
//                up++;
//                down++;
//                left = Math.max(left, 0);
//                right= Math.min(right, neighors[0].length);
//                up = Math.max(up, 0);
//                down = Math.min(down, neighors.length);
//                neighors[i][j] = sum[down][right]-sum[down][left]-sum[up][right]+sum[up][left]-board[i][j];
//                // System.out.println(neighors[i][j]);
//            }
//        }
//
//        for(int i=0;i<board.length;i++){
//            for(int j=0;j<board[0].length;j++){
//                if(board[i][j]==1){
//                    if(neighors[i][j]<2) board[i][j]=0;
//                    if(neighors[i][j]==2||neighors[i][j]==3) board[i][j]=1;
//                    if(neighors[i][j]>3) board[i][j]=0;
//                }
//                else{
//                    if(neighors[i][j]==3) board[i][j]=1;
//                }
//            }
//        }
//    }
}
