package p323;
public class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < edges.length; i++)
            unionFind.union(edges[i][0], edges[i][1]);
        return unionFind.count();
    }
    
    private static class UnionFind {
        private int n;
        private int[] ids;
        public UnionFind(int n) {
            this.n = n;
            ids = new int[n];
            for (int i = 0; i < n; i++) ids[i] = i;
        }
        public int find(int p) {
            if (p == ids[p]) return p;
            return ids[p] = find(ids[p]);
        }
        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);
            if (i == j) return;
            ids[i] = j;
            n--;
        }
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
        public int count() {
            return n;
        }
    }
}