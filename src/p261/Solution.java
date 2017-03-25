package p261;
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            if (unionFind.connected(edges[i][0], edges[i][1])) return false;
            unionFind.union(edges[i][0], edges[i][1]);
        }
        return unionFind.count() == 1;
    }
    
    private static class UnionFind {
        private int n;
        private int[] ids;
        public UnionFind(int n) {
            this.n = n;
            ids = new int[n];
            for (int i = 0; i < n; i++) ids[i] = i;
        }
        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);
            if (i == j) return;
            ids[i] = j;
            n--;
        }
        public int find(int p) {
            if (p == ids[p]) return p;
            return ids[p] = find(ids[p]);
        }
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
        public int count() {
            return n;
        }
    }
}