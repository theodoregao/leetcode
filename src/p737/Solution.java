package p737;

import java.util.HashMap;
import java.util.Map;

class Solution {
    
    private class UnionFind {
        private int[] ids;
        private int[] sizes;
        private int count;
        
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
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        
        UnionFind unionFind = new UnionFind(pairs.length * 2);
        Map<String, Integer> indexes = new HashMap<>();
        int index = 0;
        for (String[] pair: pairs) {
            if (!indexes.containsKey(pair[0])) indexes.put(pair[0], index++);
            if (!indexes.containsKey(pair[1])) indexes.put(pair[1], index++);
            unionFind.union(indexes.get(pair[0]), indexes.get(pair[1]));
        }
        
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;
            if (!indexes.containsKey(words1[i])
                    || !indexes.containsKey(words2[i])
                    || !unionFind.connected(indexes.get(words1[i]), indexes.get(words2[i]))) return false;
        }
        return true;
    }
}