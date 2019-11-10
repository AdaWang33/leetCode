import java.util.ArrayList;

public class CellsWithOddValuesInAMatrix_20191110 {
    public int oddCells(int n, int m, int[][] indices) {
        int cnt = 0;
        int[][] tmp = new int[n][m];
        for (int[] ind : indices) {
            int row = ind[0];
            int col = ind[1];
            for (int i = 0; i < n; i++) tmp[i][col] += 1;
            for (int j = 0; j < m; j++) tmp[row][j] += 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] % 2 == 1) cnt += 1;
            }
        }
        return cnt;
    }
}
