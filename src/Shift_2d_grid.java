import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shift_2d_grid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j=0;j<grid[0].length;j++){
                tmp.add(grid[i][j]);
            }
            ans.add(tmp);
        }
        if (k == 0) return ans;

        ans = shiftGrid1Time(grid, k);
        return ans;
    }


    public List<List<Integer>> shiftGrid1Time(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> all = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                all.add(grid[i][j]);
            }
        }
        for(int x = 0;x<k;x++){
            int last = all.get(all.size() - 1);
            all.remove(all.size() - 1);
            all.add(0, last);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                tmp.add(all.get(cnt));
                cnt++;
            }
            ans.add(tmp);
        }
        return ans;
    }
}
