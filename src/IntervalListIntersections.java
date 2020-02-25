import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i<A.length && j<B.length){
            // only under this condition will two intersect
            if(A[i][0]<=B[j][1] && B[j][0]<=A[i][1]){
                int left = Math.max(A[i][0], B[j][0]);
                int right = Math.min(A[i][1], B[j][1]);
                list.add(new int[]{left, right});
                if(A[i][1]<B[j][1]) i++;
                else j++;
            }else if(A[i][1]<B[j][0]){
                i++;
            }else{
                j++;
            }
        }

        int[][] res = new int[list.size()][2];
        for(int k=0;k<list.size();k++){
            res[k] = list.get(k);
        }
        return res;
    }
}
