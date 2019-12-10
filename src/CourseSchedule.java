import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * <p>
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 */


enum Visited {
    NEW, ACTIVE, DONE
}

class MyNode {
    int data;
    Visited status = Visited.NEW;
    List<MyNode> neighbors = new ArrayList<>();

    public MyNode(int data) {
        this.data = data;
    }

    public void addDirectedNeighbor(MyNode mynode) {
        this.neighbors.add(mynode);
    }
}

class Graph {
    List<MyNode> nodes = new ArrayList<>();
    HashMap<Integer, MyNode> map = new HashMap<>();

    public void addNode(int value) {
        MyNode mynode = new MyNode(value);
        nodes.add(mynode);
        map.put(value, mynode);
    }

    public void addToEdge(int i, int j) {
        MyNode source = map.get(i);
        MyNode destination = map.get(j);
        source.addDirectedNeighbor(destination);
    }
}

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph();
        for (int i = 0; i < numCourses; i++) {
            graph.addNode(i);
        }
        for (int[] pair : prerequisites) {
            graph.addToEdge(pair[1], pair[0]);
        }
        return toposort(graph);
    }

    public boolean toposort(Graph graph) {
        MyNode source = new MyNode(-1);
        for (MyNode node : graph.nodes) {
            source.addDirectedNeighbor(node);
        }
        try {
            toposortDFS(source);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void toposortDFS(MyNode node) throws Exception {
        node.status = Visited.ACTIVE;
        for (MyNode neighbor : node.neighbors) {
            if (neighbor.status == Visited.NEW) {
                toposortDFS(neighbor);
            } else if (neighbor.status == Visited.ACTIVE) {
                throw new Exception("Not a Directed Acyclic Graph (DAG). Graph has a cycle.");
            }
        }
        node.status = Visited.DONE;
    }
}
