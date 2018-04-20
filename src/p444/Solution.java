package p444;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

// Not solved...
public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Digraph digraph = new Digraph(org.length);
        Set<Integer> set = new HashSet<>();
        for (List<Integer> list: seqs)
            for (int i = 1; i < list.size(); i++)
                digraph.addEdge(list.get(i - 1) - 1, list.get(i) - 1);
        
        if (org.length == 1) {
            boolean has = false;
            if (seqs.size() == 0) return false;
            for (List<Integer> list: seqs) {
                if (list.size() > 1) return false;
                if (list.size() == 1) {
                    if (list.get(0) != org[0]) return false;
                    has = true;
                }
                else if (list.size() > 1) return false;
            }
            return has;
        }

        if (digraph.edgeCount() == 0) return org.length == 0;
        
        for (int i = 1; i < org.length; i++)
            if (!digraph.hasEdge(org[i - 1] - 1, org[i] - 1))
                return false;
        
        for (int i = 0; i < org.length; i++) set.add(org[i]);
        for (int u: digraph.vertex()) set.remove(u);
        for (int u: set) digraph.removeVertext(u);
        
        if (new Cycle(digraph).hasCycle()) return false;
        
        return true;
    }
    
    private static class Digraph {
        private Map<Integer, Set<Integer>> edges;
        private int edgeCount = 0;
        
        public Digraph(int n) {
            edges = new HashMap<>();
        }
        
        public Digraph reverse() {
            Digraph digraph = new Digraph(edges.size());
            for (Integer u: vertex()) for (Integer v: adj(u)) digraph.addEdge(v, u);
            return digraph;
        }
        
        public void addEdge(int u, int v) {
            if (!edges.containsKey(u)) edges.put(u, new HashSet<Integer>());
            if (!edges.containsKey(v)) edges.put(v, new HashSet<Integer>());
            edges.get(u).add(v);
            edgeCount++;
        }
        public void removeVertext(int u) {
            if (edges.containsKey(u)) {
                edgeCount -= edges.get(u).size();
                edges.remove(u);
            }
            for (int v: vertex()) if (edges.get(v).contains(u)) {
                edges.get(v).remove(u);
                edgeCount--;
            }
        }
        public int edgeCount() { return edgeCount; }
        public boolean hasEdge(int u, int v) { return edges.containsKey(u) && edges.get(u).contains(v); }
        public Iterable<Integer> vertex() { return edges.keySet(); }
        public int vertexCount() { return edges.keySet().size(); }
        public Iterable<Integer> adj(int u) { return edges.get(u); }
    }
    
    private static class Cycle {
        private Set<Integer> marked;
        private Stack<Integer> cycle;
        private Set<Integer> inCycle;
        
        public Cycle(Digraph digraph) {
            marked = new HashSet<>();
            inCycle = new HashSet<>();
            for (int u: digraph.vertex()) if (!marked.contains(u)) dfs(digraph, u);
        }
        
        private void dfs(Digraph digraph, int u) {
            if (hasCycle()) return;
            Stack<Integer> stack = new Stack<>();
            stack.add(u);
            while (!stack.empty()) {
                int v = stack.pop();
                marked.add(v);
                inCycle.add(v);
                
                for (int w: digraph.adj(v)) {
                    if (!marked.contains(w)) {
                        marked.add(w);
                        stack.push(w);
                    }
                    else if (inCycle.contains(w)) {
                        cycle = new Stack<>();
                        cycle.add(w);
                        break;
                    }
                }
                
                if (hasCycle()) cycle.add(u);
            }
        }
        
        public boolean hasCycle() { return cycle != null; }
        public boolean isDag() { return cycle == null; }
        public Iterable<Integer> cycle() { return cycle; }
    }
}