import java.util.*;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int res = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][1] == Integer.MAX_VALUE) continue;
                if (intervals[i][1] >= intervals[j][1]) {
                    res--;
                    intervals[j][1] = Integer.MAX_VALUE;
                } else continue;
            }
        }
        return res;
    }
}
