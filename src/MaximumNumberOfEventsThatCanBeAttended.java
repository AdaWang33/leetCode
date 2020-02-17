import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {
        if(events==null||events.length==0) return 0;

        int res = 0;
        Arrays.sort(events, (a, b)->a[0]-b[0]);
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int day=0;day<=100000;day++){
            while(idx<events.length&&events[idx][0]==day){
                pq.offer(events[idx][1]);
                idx++;
            }

            while(!pq.isEmpty()&&pq.peek()<day){
                pq.poll();
            }

            if(!pq.isEmpty()){
                res++;
                pq.poll();
            }
        }

        return res;
}
