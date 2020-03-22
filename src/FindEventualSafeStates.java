/**
 * In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.
 *
 * Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.
 *
 * Which nodes are eventually safe?  Return them as an array in sorted order.
 *
 * The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.
 *
 * Example:
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Here is a diagram of the above graph.
 */


import java.util.*;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int num = graph.length;
        Map<Integer, Integer> outdegree = new HashMap<>();
        Map<Integer, List<Integer>> outs = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<num;i++){
            int a = i;
            int[] list = graph[i];
            for(int b : list){
                outs.putIfAbsent(b, new ArrayList<>());
                outs.get(b).add(a);
            }
            outdegree.put(a, list.length);
            if(outdegree.get(i)==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(outs.containsKey(cur)){
                List<Integer> curList = outs.get(cur);
                for(int in:curList){
                    outdegree.put(in, outdegree.get(in)-1);
                    if(outdegree.get(in)==0) queue.offer(in);
                }
            }
            res.add(cur);
        }
        Collections.sort(res);
        return res;
    }

}