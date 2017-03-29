package p269;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {
    
    public static void main(String[] args) {
        System.out.println(new Solution().alienOrder(new String[] {"wnlb"}));
    }
    
    public String alienOrder(String[] words) {
        Digraph digraph = new Digraph();
        for (String word: words) for (char c: word.toCharArray()) digraph.addEdge(c, c);
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                char[] differece = different(words[j], words[i]);
                if (differece.length == 2) digraph.addEdge(differece[0], differece[1]);
            }
        }
        if (new Cycle(digraph).hasCycle()) return "";
        StringBuffer sb = new StringBuffer();
        for (int u: new TopologicalSort(digraph).order()) sb.append((char) u);
        return sb.toString();
    }
    
    private char[] different(String up, String down) {
        for (int i = 0; i < up.length() && i < down.length(); i++)
            if (up.charAt(i) != down.charAt(i))
                return new char[] {up.charAt(i), down.charAt(i)};
        return new char[0];
    }
    
    private static class Digraph {
        private Map<Integer, Set<Integer>> edges = new HashMap<>();
        public void addEdge(int u, int v) {
            if (!edges.containsKey(u)) edges.put(u, new HashSet<>());
            if (!edges.containsKey(v)) edges.put(v, new HashSet<>());
            if (u == v) return;
            edges.get(u).add(v);
        }
        public Iterable<Integer> vertex() { return edges.keySet(); }
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
            marked.add(u);
            inCycle.add(u);
            for (int v: digraph.adj(u)) {
                if (!marked.contains(v)) dfs(digraph, v);
                else if (inCycle.contains(v)) {
                    cycle = new Stack<>();
                    cycle.add(v);
                    break;
                }
            }
            inCycle.remove(u);
            if (cycle != null) cycle.push(u);
        }
        public boolean isDag() { return cycle == null; }
        public boolean hasCycle() { return cycle != null; }
        public Iterable<Integer> cycle() { return cycle; }
    }
    
    private static class DfsOrder {
        private Set<Integer> marked;
        private Queue<Integer> pre;
        private Queue<Integer> post;
        private Stack<Integer> reversePost;
        public DfsOrder(Digraph digraph) {
            marked = new HashSet<>();
            pre = new LinkedList<>();
            post = new LinkedList<>();
            reversePost = new Stack<>();
            for (int u: digraph.vertex()) if (!marked.contains(u)) dfs(digraph, u);
        }
        private void dfs(Digraph digraph, int u) {
            marked.add(u);
            pre.add(u);
            for (int v: digraph.adj(u)) if (!marked.contains(v)) dfs(digraph, v);
            post.add(u);
            reversePost.push(u);
        }
        public Iterable<Integer> preOrder() { return pre; }
        public Iterable<Integer> postOrder() { return post; }
        public Iterable<Integer> reversePostOrder() { return reversePost; }
    }
    
    private static class TopologicalSort {
        private Iterable<Integer> order;
        public TopologicalSort(Digraph digraph) {
            if (new Cycle(digraph).isDag()) order = new DfsOrder(digraph).reversePostOrder();
        }
        public boolean hasTopologicalSort() { return order != null; }
        public Iterable<Integer> order() { return order; }
    }
}