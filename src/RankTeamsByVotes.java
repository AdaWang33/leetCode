import java.util.*;

public class RankTeamsByVotes {
    public String rankTeams(String[] votes) {
        // priority queue: max heapify: O(nlogn), poll() && offer(): O(logn)
        // you can't use premitives with comparator
        if (votes.length == 1) return votes[0];
        Map<Character, int[]> map = new HashMap<>();

//        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
//            int[] alist = map.get(a);
//            int[] blist = map.get(b);
//            for (int i = 0; i < alist.length; i++) {
//                if (alist[i] != blist[i]) return blist[i] - alist[i];
//            }
//            return a - b;
//        });

        for (String vote : votes) {
            char[] chars = vote.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                map.putIfAbsent(chars[i], new int[chars.length]);
                map.get(chars[i])[i]++;
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            int[] alist = map.get(a);
            int[] blist = map.get(b);
            for (int i = 0; i < alist.length; i++) {
                if (alist[i] != blist[i]) return blist[i] - alist[i];
            }
            return Character.compare(a, b);
        });

        StringBuilder sb = new StringBuilder();
        for (char c : list) sb.append(c);
        return sb.toString();
    }
}
