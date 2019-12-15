public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
    int m, n;
    int[][] sumArr;

    public int maxSideLength(int[][] mat, int threshold) {
        m = mat.length;
        n = mat[0].length;
        sumArr = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + mat[i-1][j-1];
            }
        }

        for (int len = Math.min(m, n); len > 0; len--) {
            for (int i = 0; i <= m - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    int sum = sumOfSquare(sumArr, i, j, len);
                    if (sum <= threshold) return len;
                }
            }
        }
        return 0;
    }

    public int sumOfSquare(int[][] sumArr, int r, int c, int len) {
        return sumArr[r + len][c + len] - sumArr[r][c + len] - sumArr[r + len][c] + sumArr[r][c];
    }
}
