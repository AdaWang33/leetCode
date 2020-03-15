import java.util.ArrayList;
import java.util.List;

/**
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 *
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
 * Example 2:
 *
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * Example 3:
 *
 * Input: matrix = [[7,8],[1,2]]
 * Output: [7]
 */

public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0) return res;

        int[] rowMin = new int[matrix.length];
        int[] colMax = new int[matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            // int[] curRow = matrix[i].clone();
            // Arrays.sort(curRow);
            // rowMin[i] = curRow[0];
            int min = matrix[i][0];
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<min) min = matrix[i][j];
            }
            rowMin[i] = min;
        }

        for(int j=0;j<matrix[0].length;j++){
            int max = matrix[0][j];
            for(int i=0;i<matrix.length;i++){
                if(matrix[i][j]>max) max = matrix[i][j];
            }
            colMax[j] = max;
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==rowMin[i] && matrix[i][j]==colMax[j]) res.add(matrix[i][j]);
            }
        }
        return res;
    }
}
