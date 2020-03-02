import java.util.*;

public class RankTeamsByVotes {
    public String rankTeams(String[] votes) {
        if(votes.length==1) return votes[0];
        Map<Character, List<Integer>> map = new HashMap<>();

        String res = "";
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b)->{
            List<Integer> alist = map.get(a);
            List<Integer> blist = map.get(b);
            for(int i=0;i<alist.size();i++){
                if(alist.get(i)!=blist.get(i)) return alist.get(i)-blist.get(i);
            }
            return a-b;
        });

        for(String vote:votes){
            char[] chars = vote.toCharArray();
            for(int i=0;i<chars.length;i++){
                List<Integer> list = map.getOrDefault(chars[i], new ArrayList<>());
                list.add(i);
                Collections.sort(list);
                map.put(chars[i], list);
            }
        }

        for(char c:votes[0].toCharArray()){
            pq.offer(c);
        }

        while(!pq.isEmpty()){
            res+=pq.poll();
        }

        return res;
    }
}
