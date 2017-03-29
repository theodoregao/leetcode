package p133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};

public class Solution {
    public static void main(String[] args) {
        UndirectedGraphNode undirectedGraphNode0 = new UndirectedGraphNode(0);
        UndirectedGraphNode undirectedGraphNode1 = new UndirectedGraphNode(1);
        UndirectedGraphNode undirectedGraphNode2 = new UndirectedGraphNode(2);
        UndirectedGraphNode undirectedGraphNode3 = new UndirectedGraphNode(3);
        UndirectedGraphNode undirectedGraphNode4 = new UndirectedGraphNode(4);
        UndirectedGraphNode undirectedGraphNode5 = new UndirectedGraphNode(5);
        undirectedGraphNode0.neighbors.add(undirectedGraphNode1);
        undirectedGraphNode0.neighbors.add(undirectedGraphNode5);
        undirectedGraphNode1.neighbors.add(undirectedGraphNode2);
        undirectedGraphNode1.neighbors.add(undirectedGraphNode5);
        undirectedGraphNode2.neighbors.add(undirectedGraphNode3);
        undirectedGraphNode3.neighbors.add(undirectedGraphNode4);
        undirectedGraphNode3.neighbors.add(undirectedGraphNode4);
        undirectedGraphNode4.neighbors.add(undirectedGraphNode5);
        undirectedGraphNode4.neighbors.add(undirectedGraphNode5);
        
        Set<Integer> marked = new HashSet<>();
        print(marked, new Solution().cloneGraph(undirectedGraphNode0));
    }
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Set<Integer> marked = new HashSet<>();
        Map<Integer, UndirectedGraphNode> nodes = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        marked.add(node.label);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            if (!nodes.containsKey(head.label)) nodes.put(head.label, new UndirectedGraphNode(head.label));
            UndirectedGraphNode headCopy = nodes.get(head.label);
            for (UndirectedGraphNode neighbor: head.neighbors) {
                if (!nodes.containsKey(neighbor.label)) nodes.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                headCopy.neighbors.add(nodes.get(neighbor.label));
                if (!marked.contains(neighbor.label)) {
                    marked.add(neighbor.label);
                    queue.offer(neighbor);
                }
            }
        }
        return nodes.get(node.label);
    }
    
    private static void print(Set<Integer> marked, UndirectedGraphNode node) {
        if (node == null) return;
        marked.add(node.label);
        print(node);
        for (UndirectedGraphNode neighbor: node.neighbors) {
            if (!marked.contains(neighbor.label)) print(marked, neighbor);
        }
    }
    private static void print(UndirectedGraphNode node) {
        if (node == null) return;
        System.out.println("node: " + node.label);
        for (UndirectedGraphNode neighbor: node.neighbors)
            System.out.println("\t" + neighbor.label);
    }
}