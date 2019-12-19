public class SpiralMatrixII {
    int[][] res;

    public int[][] generateMatrix(int n) {
        res = new int[n][n];

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int index = 1;
        while (true) {
            for (int i = left; i <= right; i++) res[top][i] = index++;
            top++;
            if (index > n * n) break;


            for (int i = top; i <= bottom; i++) res[i][right] = index++;
            right--;
            if (index > n * n) break;


            for (int i = right; i >= left; i--) res[bottom][i] = index++;
            bottom--;
            if (index > n * n) break;

            for (int i = bottom; i >= top; i--) res[i][left] = index++;
            left++;
            if (index > n * n) break;
        }
        return res;
    }
}
