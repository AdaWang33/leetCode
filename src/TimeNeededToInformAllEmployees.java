import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInformAllEmployees {
    Map<Integer, List<Integer>> map;
    int[] time;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // confusing description
        // note: https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/532573/I-don't-know-why-this-case-failed...
        map = new HashMap<>();
        for(int i=0; i<manager.length; i++){
            if(manager[i]==-1) continue;
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        time = informTime;
        return dfs(headID);
    }

    public int dfs(int manager){
        int max = 0;
        if(!map.containsKey(manager)) return max;

        List<Integer> emps = map.get(manager);
        for(int emp:emps) max=Math.max(max, dfs(emp));
        return time[manager]+max;
    }


//         int res = 0;
//         if(manager.length==1) return res;
//         Map<Integer, List<Integer>> map = new HashMap<>();
//         Queue<Integer> queue = new LinkedList<>();

//         for(int i=0;i<manager.length;i++){
//             if(manager[i]!=-1){
//                 map.putIfAbsent(manager[i], new ArrayList<>());
//                 map.get(manager[i]).add(i);
//             }
//         }

//         queue.offer(headID);

//         while(!queue.isEmpty()){
//             int curTime = 0;
//             int size = queue.size();
//             for(int i=0;i<size;i++){
//                 int curMng = queue.poll();
//                 System.out.print(curMng+"; ");
//                 if(!map.containsKey(curMng)) continue;
//                 for(int emp:map.get(curMng)){
//                     queue.offer(emp);
//                 }
//                 curTime = Math.max(curTime, informTime[curMng]);
//             }
//             System.out.println("--");
//             res+=curTime;
//         }

//         return res;
//     }
}
