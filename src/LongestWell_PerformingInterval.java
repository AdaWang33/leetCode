import java.util.HashMap;

public class LongestWell_PerformingInterval {
    public int longestWPI(int[] hours) {
        // 本质是:先把数组换成由-1和1,转化为找一个maximum size subarray 让它的和大于 0.
        int ans = 0;
        int score = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // 对应score和idx
        for (int i = 0; i < hours.length; i++) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) ans = i + 1;
            else {
                map.putIfAbsent(score, i);
                if (map.containsKey(score - 1)) {
                    ans = Math.max(ans, i - map.get(score - 1));
                }

            }
        }
        return ans;

    }
}
