import java.util.*;

/**
 * Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.
 *
 * Example 1:
 *
 * Input:
 * org: [1,2,3], seqs: [[1,2],[1,3]]
 *
 * Output:
 * false
 *
 * Explanation:
 * [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.
 * Example 2:
 *
 * Input:
 * org: [1,2,3], seqs: [[1,2]]
 *
 * Output:
 * false
 *
 * Explanation:
 * The reconstructed sequence can only be [1,2].
 * Example 3:
 *
 * Input:
 * org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]
 *
 * Output:
 * true
 *
 * Explanation:
 * The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
 * Example 4:
 *
 * Input:
 * org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]
 *
 * Output:
 * true
 */

public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            return indegree.get(a)-indegree.get(b);
        });

        //  build up list and indegree
        for(int i=0;i<seqs.size();i++){
            List<Integer> list = seqs.get(i);
            if(list.size()==1){
                if(!map.containsKey(list.get(0))){
                    map.put(list.get(0), new HashSet<>());
                    indegree.put(list.get(0), 0);
                }
            }else{
                for(int j=0;j<list.size()-1;j++){
                    int a = list.get(j);
                    int b = list.get(j+1);
                    if(!map.containsKey(a)){
                        map.put(a, new HashSet<>());
                        indegree.put(a, 0);
                    }
                    if(!map.containsKey(b)){
                        map.put(b, new HashSet<>());
                        indegree.put(b, 0);
                    }
                    if(!map.get(a).contains(b)){
                        map.get(a).add(b);
                        indegree.put(b, indegree.get(b)+1);
                    }
                }
            }
        }

        // put everyone with an indegree of 0 into the queue
        for(Integer entry:indegree.keySet()){
            if(indegree.get(entry)==0) pq.offer(entry);
        }

        int index = 0;
        while(!pq.isEmpty()){
            if(pq.size()>1) return false;
            int cur = pq.poll();
            if(index>=org.length || cur!=org[index]) return false;
            Set<Integer> set = map.get(cur);
            for(int ele:set){
                indegree.put(ele, indegree.get(ele)-1);
                if(indegree.get(ele)==0) pq.offer(ele);
            }
            index++;
        }

        return index==org.length&&index==map.size();
    }
}
