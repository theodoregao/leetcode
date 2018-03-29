package p547;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int _findCircleNum(int[][] M) {
        Graph graph = new Graph();
        for (int i = 0; i < M.length; i++)
            for (int j = i; j < M.length; j++)
                if (M[i][j] != 0) graph.addEdge(i, j);
        System.out.println(graph.vertex().size());
        System.out.println(new ConnectedComponent(graph).getCount());
        return new ConnectedComponent(graph).getCount();
    }
    
    public int findCircleNum(int[][] M) {
        UnionFind unionFind = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) unionFind.union(i, j);
            }
        }
        return unionFind.count();
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
    
    private class UnionFind {
        private int count;
        private int[] ids;
        private int[] sizes;
        
        public UnionFind(int n) {
            count = n;
            ids = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                ids[i] = i;
                sizes[i] = 1;
            }
        }
        
        public int find(int p) {
            if (ids[p] == p) return p;
            return ids[p] = find(ids[p]);
        }
        
        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);
            if (i == j) return;
            if (sizes[i] > sizes[j]) {
                ids[j] = i;
                sizes[i] += sizes[j];
            }
            else {
                ids[i] = j;
                sizes[j] += sizes[i];
            }
            count--;
        }
        
        public int count() {
            return count;
        }
    }
}