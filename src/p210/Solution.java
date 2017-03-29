package p210;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Digraph digraph = new Digraph(numCourses);
        for (int[] prerequisite: prerequisites) digraph.addEdge(prerequisite[0], prerequisite[1]);
        TopologicalSort topologicalSort = new TopologicalSort(digraph);
        if (!topologicalSort.hasTopologicalOrder()) return new int[0];
        int[] order = new int[numCourses];
        int i = 0;
        for (int u: topologicalSort.order()) order[i++] = u;
        return order;
    }
    
    private static class Digraph {
        private Map<Integer, Set<Integer>> edges;
        
        public Digraph(int n) {
            edges = new HashMap<>();
            for (int i = 0; i < n; i++) edges.put(i, new HashSet<>());
        }
        
        public Digraph reverse() {
            Digraph digraph = new Digraph(edges.size());
            for (Integer u: vertex()) for (Integer v: adj(u)) digraph.addEdge(v, u);
            return digraph;
        }
        
        public void addEdge(int u, int v) { edges.get(u).add(v); }
        public Iterable<Integer> vertex() { return edges.keySet(); }
        public int vertexCount() { return edges.keySet().size(); }
        public Iterable<Integer> adj(int u) { return edges.get(u); }
    }
    
    private static class DfsOrder {
        private boolean[] marked;
        private Queue<Integer> pre;
        private Queue<Integer> post;
        private Stack<Integer> reversePost;
        
        public DfsOrder(Digraph digraph) {
            marked = new boolean[digraph.vertexCount()];
            pre = new LinkedList<>();
            post = new LinkedList<>();
            reversePost = new Stack<>();
            for (int u: digraph.vertex()) if (!marked[u]) dfs(digraph, u);
        }
        
        private void dfs(Digraph digraph, int u) {
            marked[u] = true;
            pre.add(u);
            for (int v: digraph.adj(u)) if (!marked[v]) dfs(digraph, v);
            post.add(u);
            reversePost.push(u);
        }

        public Iterable<Integer> pre() { return pre; }
        public Iterable<Integer> post() { return post; }
        public Iterable<Integer> reversePost() { return reversePost; }
    }
    
    private static class Cycle {
        private boolean[] marked;
        private Stack<Integer> cycle;
        private Set<Integer> inCycle;
        
        public Cycle(Digraph digraph) {
            marked = new boolean[digraph.vertexCount()];
            inCycle = new HashSet<>();
            for (int u: digraph.vertex()) if (!marked[u]) dfs(digraph, u);
        }
        
        private void dfs(Digraph digraph, int u) {
            if (hasCycle()) return;
            marked[u] = true;
            inCycle.add(u);
            for (int v: digraph.adj(u)) {
                if (!marked[v]) dfs(digraph, v);
                else if (inCycle.contains(v)) {
                    cycle = new Stack<>();
                    cycle.push(v);
                    break;
                }
            }
            inCycle.remove(u);
            if (hasCycle()) cycle.add(u);
        }
        
        public boolean hasCycle() { return cycle != null; }
        public boolean isDag() { return cycle == null; }
        public Iterable<Integer> cycle() { return cycle; }
    }
    
    private static class TopologicalSort {
        private Iterable<Integer> order;
        public TopologicalSort(Digraph digraph) {
            if (new Cycle(digraph).isDag()) order = new DfsOrder(digraph).reversePost();
        }
        
        public boolean hasTopologicalOrder() { return order != null; }
        public Iterable<Integer> order() { return order; }
    }
}