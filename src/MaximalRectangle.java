public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        if (matrix.length == 0) return ans;

        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                    continue;
                }
                height[j]++;
                for (int idx = j, top = height[j]; idx > -1; idx--) {
                    top = Math.min(top, height[idx]);
                    ans = Math.max(ans, top * (j - idx + 1));
                }
            }
        }
        return ans;
    }
}
