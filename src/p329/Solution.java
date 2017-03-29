package p329;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {
    private static int[][] DIR = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestIncreasingPath(new int[][] {{9,9,4},{6,6,8},{2,1,1}}));
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        else if (matrix.length == 1 && matrix[0].length == 1) return 1;
        Digraph digraph = new Digraph();
        int ROW = matrix.length;
        int COL = matrix[0].length;
        for (int r = 0; r < ROW; r++) for (int c = 0; c < COL; c++) {
            for (int i = 0; i < DIR.length; i++) {
                int rr = r + DIR[i][0];
                int cc = c + DIR[i][1];
                if (valid(matrix, rr, cc) && matrix[r][c] < matrix[rr][cc])
                    digraph.addEdge(index(matrix, r, c), index(matrix, rr, cc));
            }
        }
        return new LongestIncreasingOrder(digraph).max();
    }
    
    private boolean valid(int[][] matrix, int r, int c) {
        return r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length;
    }
    
    private int index(int[][] matrix, int r, int c) {
        return r * matrix[0].length + c;
    }
    
    private static class Digraph {
        private Map<Integer, Set<Integer>> edges = new HashMap<>();
        public void addEdge(int u, int v) {
            if (!edges.containsKey(u)) edges.put(u, new HashSet<>());
            if (!edges.containsKey(v)) edges.put(v, new HashSet<>());
            edges.get(u).add(v);
        }
        public Digraph reverse() {
            Digraph digraph = new Digraph();
            for (int u: vertex()) for (int v: adj(u)) digraph.addEdge(v, u);
            return digraph;
        }
        public Iterable<Integer> vertex() { return edges.keySet(); }
        public Iterable<Integer> adj(int u) { return edges.get(u); }
        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer(Digraph.class.getSimpleName());
            sb.append("{");
            for (int u: vertex()) {
                sb.append("\n").append(u).append("->");
                for (int v: adj(u)) sb.append(v).append(",");
            }
            sb.append("}");
            return sb.toString();
        }
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
            for (int v: digraph.adj(u))
                if (!marked.contains(v)) dfs(digraph, v);
                else if (inCycle.contains(v)) {
                    cycle = new Stack<>();
                    cycle.add(v);
                    break;
                }
            inCycle.remove(u);
            if (cycle != null) cycle.add(u);
        }
        public boolean isDag() { return cycle == null; }
        public boolean hasCycle() { return cycle != null; }
        public Iterable<Integer> cycle() { return cycle; }
    }
    
    private static class DfsOrder {
        private Set<Integer> marked;
//        private Queue<Integer> pre;
//        private Queue<Integer> post;
        private Stack<Integer> reversePost;
        public DfsOrder(Digraph digraph) {
            marked = new HashSet<>();
//            pre = new LinkedList<>();
//            post = new LinkedList<>();
            reversePost = new Stack<>();
            for (int u: digraph.vertex())
                if (!marked.contains(u)) dfs(digraph, u);
        }
        private void dfs(Digraph digraph, int u) {
            marked.add(u);
//            pre.add(u);
            for (int v: digraph.adj(u)) if (!marked.contains(v)) dfs(digraph, v);
//            post.add(u);
            reversePost.push(u);
        }
        public Iterable<Integer> reversePost() { return reversePost; }
    }
    
    private static class TopologicalSort {
        private Iterable<Integer> order;
        public TopologicalSort(Digraph digraph) {
//            if (new Cycle(digraph).isDag())
                order = new DfsOrder(digraph).reversePost();
        }
        public boolean hasTopologicalSort() { return order != null; }
        public Iterable<Integer> order() { return order; }
    }
    
    private static class LongestIncreasingOrder {
        private Map<Integer, Integer> length;
        private int max;
        public LongestIncreasingOrder(Digraph digraph) {
            max = 0;
            length = new HashMap<>();
            for (int u: new TopologicalSort(digraph.reverse()).order()) {
                if (!length.containsKey(u)) dfs(digraph, u, 1);
            }
        }
        private void dfs(Digraph digraph, int u, int n) {
            length.put(u, n);
            if (n > max) max = n;
            for (int v: digraph.adj(u)) if (!length.containsKey(v) || length.get(v) <= n) dfs(digraph, v, n + 1);
        }
        public int max() { return max; }
    }
}