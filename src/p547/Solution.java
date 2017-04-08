package p547;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int findCircleNum(int[][] M) {
        Graph graph = new Graph();
        for (int i = 0; i < M.length; i++)
            for (int j = i; j < M.length; j++)
                if (M[i][j] != 0) graph.addEdge(i, j);
        System.out.println(graph.vertex().size());
        System.out.println(new ConnectedComponent(graph).getCount());
        return new ConnectedComponent(graph).getCount();
    }
    
    private class Graph {
        private Map<Integer, Set<Integer>> edges = new HashMap<>();
        public void addEdge(int u, int v) {
            if (!edges.containsKey(u)) edges.put(u, new HashSet<>());
            if (!edges.containsKey(v)) edges.put(v, new HashSet<>());
            if (u == v) return;
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        public Set<Integer> vertex() { return edges.keySet(); }
        public Set<Integer> adj(int u) { return edges.get(u); }
    }
    
    private class ConnectedComponent {
        private int count;
        private Set<Integer> marked;
        public ConnectedComponent(Graph graph) {
            marked = new HashSet<>();
            count = 0;
            for (int u: graph.vertex()) {
                if (!marked.contains(u)) {
                    dfs(graph, u);
                    count++;
                }
            }
        }
        private void dfs(Graph graph, int u) {
            marked.add(u);
            for (int v: graph.adj(u))
                if (!marked.contains(v)) dfs(graph, v);
        }
        public int getCount() { return count; }
    }
}