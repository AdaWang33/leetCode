import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveInterval extends ArrayList {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();

        int begin = toBeRemoved[0];
        int end = toBeRemoved[1];

        for (int[] interval : intervals) {
            if (Math.max(interval[0], begin) < Math.min(end, interval[1])) {
                if (begin < interval[0] && interval[1] < end) {
                    continue;
                } else if (interval[0] < begin && end < interval[1]) {
                    res.add(new ArrayList<>(Arrays.asList(interval[0], begin)));
                    res.add(new ArrayList<>(Arrays.asList(end, interval[1])));
                } else if (interval[0] < begin) {
                    res.add(new ArrayList<>(Arrays.asList(interval[0], begin)));
                } else if (end < interval[1]) {
                    res.add(new ArrayList<>(Arrays.asList(end, interval[1])));
                }
            } else {
//                res.add(new ArrayList<>(Arrays.asList(interval[0], interval[1])));
                res.add(new ArrayList<Integer>() {{
                    add(interval[0]);
                    add(interval[1]);
                }});
            }
        }
        return res;
    }
}
