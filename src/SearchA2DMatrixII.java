public class SearchA2DMatrixII {
    // Search Space Reduction, 找到一个点：往大往小界限清晰
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;

        int i = 0;
        int j = matrix[0].length-1;
        while(i>=0&&i<matrix.length&&j>=0&&j<matrix[0].length){
            if(matrix[i][j]==target) return true;
            else if(matrix[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
