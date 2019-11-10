import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given the following details of a matrix with n columns and 2 rows :
 * <p>
 * The matrix is a binary matrix, which means each element in the matrix can be 0 or 1.
 * The sum of elements of the 0-th(upper) row is given as upper.
 * The sum of elements of the 1-st(lower) row is given as lower.
 * The sum of elements in the i-th column(0-indexed) is colsum[i], where colsum is given as an integer array with length n.
 * Your task is to reconstruct the matrix with upper, lower and colsum.
 * <p>
 * Return it as a 2-D integer array.
 * <p>
 * If there are more than one valid solution, any of them will be accepted.
 * <p>
 * If no valid solution exists, return an empty 2-D array.
 */

public class ReconstructA2RowBinaryMatrix_20191110 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>();
        int colSum = 0;
        for (int tmp : colsum) colSum += tmp;
        if (colSum != upper + lower) return res;
        List<Integer> upList = Arrays.asList(new Integer[colsum.length]);
        List<Integer> lowList = Arrays.asList(new Integer[colsum.length]);


        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                upList.set(i, 1);
                lowList.set(i, 1);
                upper -= 1;
                lower -= 1;
            }
        }
        if (upper<0 || lower<0) {
            return res;
        }

        for (int i=0;i<colsum.length;i++) {
            int sum = colsum[i];
            if (sum == 0) {
                upList.set(i,0);
                lowList.set(i,0);
            } else if (sum == 1 && upper > 0) {
                upList.set(i,1);
                lowList.set(i,0);
                upper -= 1;
            } else if (sum == 1 && lower > 0) {
                lowList.set(i,1);
                upList.set(i,0);
                lower -= 1;
            }
        }
        res.add(upList);
        res.add(lowList);
        return res;
    }
}
