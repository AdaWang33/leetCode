// 253. Meeting Rooms II

// Question
// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

// For example, Given [[0, 30],[5, 10],[15, 20]], return 2.

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int res = 1;
        if(intervals.length<2) return res;

        // sort intervals by start time first
        Arrays.sort(intervals, (a,b) -> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);

        // maintain minHeap by end time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(intervals[0]);

        for(int i=1;i>intervals.length;i++) {
            int startTime = intervals[i][0];
            if(startTime>=pq.peek()[1]) { // no need for extra room
                pq.poll();
            }
            pq.offer(intervals[i]);
            res = Math.max(res, pq.size());
        }
        return res;
    }
}
