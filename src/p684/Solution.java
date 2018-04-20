package p684;
class Solution {
	
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
			else return ids[p] = find(ids[p]);
		}
		
		public boolean connected(int p, int q) {
			return find(p) == find(q);
		}
		
		public void union(int p, int q) {
			if (connected(p, q)) return;
			int i = find(p);
			int j = find(q);
			if (sizes[i] < sizes[j]) {
				ids[i] = j;
				sizes[j] += sizes[i];
			}
			else {
				ids[j] = i;
				sizes[i] += sizes[j];
			}
			count--;
		}
	}
	
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(1001);
        for (int i = 0; i < edges.length; i++) {
        	if (unionFind.connected(edges[i][0], edges[i][1]))
        		return edges[i];
        	unionFind.union(edges[i][0], edges[i][1]);
        }
        return new int[2];
    }
}