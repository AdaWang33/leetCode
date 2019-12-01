public class CountSquareSubmatricesWithAllOnes {
    int cnt = 0;

    public int countSquares(int[][] matrix) {
        int maxLen = Math.min(matrix.length, matrix[0].length);
        for (int len = maxLen; len > 0; len--) {
            for (int i = 0; i <= matrix.length - len; i++) {
                for (int j = 0; j <= matrix[0].length - len; j++) {
                    checkifall1(matrix, i, j, len);
                }
            }
        }
        return cnt;
    }

    public void checkifall1(int[][] matrix, int m, int n, int len) {
        for (int i = m; i < m + len; i++) {
            for (int j = n; j < n + len; j++) {
                if (matrix[i][j] != 1) return;
            }
        }
        cnt += 1;
    }
}
