package p279;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    
    public int numSquares(int n) {
        return dpSolution(n);
    }
    
    private int dpSolution(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) dp[i] = i;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            int pow = i * i;
            for (int j = pow; j <= n; j++) dp[j] = Math.min(dp[j], dp[j - pow] + 1);
        }
        return dp[n];
    }
    
    private int graphSolution(int n) {
        Digraph digraph = new Digraph();
        int sqrt = (int) Math.sqrt(n);
        for (int i = n; i > 0; i--) digraph.addEdge(i, i - 1);
        for (int delta = 2; delta <= sqrt; delta++) {
            int pow = delta * delta;
            for (int u: digraph.vertex()) {
                int k = u;
                while (k - pow >= 0) digraph.addEdge(k, (k -= pow));
            }
        }
        return new ShortestPath(digraph, n).getShortestPath().size();
    }
    
    private static class Digraph {
        private Map<Integer, Set<Integer>> edges = new HashMap<>();
        
        public void addEdge(int u, int v) {
            if (!edges.containsKey(u)) edges.put(u, new HashSet<>());
            if (!edges.containsKey(v)) edges.put(v, new HashSet<>());
            edges.get(u).add(v);
        }
        public Set<Integer> vertex() { return edges.keySet(); }
        public Set<Integer> adj(int u) { return edges.get(u); }
    }
    
    private static class ShortestPath {
        private Deque<Integer> shortestPath;
        public ShortestPath(Digraph digraph, int u) {
            Queue<Integer> queue = new LinkedList<>();
            int[] from = new int[u];
            queue.add(u);
            int v = u;
            boolean found = false;
            while (!found && !queue.isEmpty()) {
                v = queue.poll();
                for (int w: digraph.adj(v)) if (from[w] == 0) {
                    from[w] = v;
                    if (w == 0) {
                        found = true;
                        break;
                    }
                    queue.offer(w);
                }
            }
            shortestPath = new LinkedList<>();
            int k = 0;
            while (k != u) {
                k = from[k];
                shortestPath.addLast(k);
            }
        }
        public Deque<Integer> getShortestPath() { return shortestPath; }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(475));
    }
}