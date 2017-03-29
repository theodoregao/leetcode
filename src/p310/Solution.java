package p310;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        if (n == 1) {
            list.add(0);
            return list;
        }
        
        Graph graph = new Graph();
        for (int i = 0; i < edges.length; i++) graph.addEdge(edges[i][0], edges[i][1]);
        
        Deque<Integer> longPathStartWith0 = new BfsOrder(graph, 0).getLongestPath();
        Deque<Integer> longestPath = new BfsOrder(graph, longPathStartWith0.getLast()).getLongestPath();
        
        while (longestPath.size() > 2) {
            longestPath.removeFirst();
            longestPath.removeLast();
        }
        list.addAll(longestPath);
        
        return list;
    }
    
    private static class Graph {
        private Map<Integer, Set<Integer>> edges = new HashMap<>();
        
        public void addEdge(int u, int v) {
            if (!edges.containsKey(u)) edges.put(u, new HashSet<>());
            if (!edges.containsKey(v)) edges.put(v, new HashSet<>());
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        
        public Set<Integer> adj(int u) {
            return edges.get(u);
        }
        
        public int degree(int u) {
            return adj(u).size();
        }
        
        public Set<Integer> vertex() {
            return edges.keySet();
        }
    }
    
    private static class BfsOrder {
        private Set<Integer> marked;
        private Deque<Integer> longestPath;
        private int[] from;
        public BfsOrder(Graph graph, int u) {
            marked = new HashSet<>();
            longestPath = new LinkedList<>();
            from = new int[graph.vertex().size()];
            from[u] = u;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(u);
            marked.add(u);
            int v = u;
            while (!queue.isEmpty()) {
                v = queue.poll();
                for (int w: graph.adj(v)) if (!marked.contains(w)) {
                    marked.add(w);
                    from[w] = v;
                    queue.add(w);
                }
            }
            
            while (v != u) {
                longestPath.addFirst(v);
                v = from[v];
            }
            longestPath.addFirst(u);
        }
        public Deque<Integer> getLongestPath() { return longestPath; }
    }
    
    public static void main(String[] args) {
        for (int u: new Solution().findMinHeightTrees(6, new int[][] {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}))
            System.out.println(u);
    }
}