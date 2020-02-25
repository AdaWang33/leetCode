public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int r = A[0].length;
        int n = B[0].length;
        int[][] res = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int cnt = 0;
                for(int k=0;k<r;k++){
                    cnt+=A[i][k]*B[k][j];
                }
                res[i][j] = cnt;
            }
        }
        return res;
    }
}
