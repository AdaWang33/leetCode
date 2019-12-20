import java.util.*;


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

public class CloneGraph {
    HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return cloneNode(node);
    }

    public Node cloneNode(Node node) {
        if (node == null) return node;
        if (map.containsKey(node.val)) return map.get(node.val);

        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node.val, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneNode(neighbor));
        }
        return newNode;
    }
}
