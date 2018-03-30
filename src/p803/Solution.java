package p803;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// warning: not accepted, TLE
class Solution {
    
    private static final int[][] DIR = new int[][] {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };
    
    private class UnionFind {
        
        private int n;
        private int[] ids;
        private int[] sizes;
        
        public UnionFind(int n) {
            this.n = n;
            ids = new int[n + 1];
            sizes = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                ids[i] = i;
                sizes[i] = 1;
            }
        }
        
        public int find(int p) {
            if (ids[p] == p) return p;
            else return ids[p] = find(ids[p]);
        }
        
        public boolean isConnectToTop(int p) {
            return find(p) == find(n);
        }
        
        public void union(int p, int q) {
            int i = ids[p];
            int j = ids[q];
            if (i == j) return;
            if (sizes[i] > sizes[j]) {
                ids[j] = i;
                sizes[i] += sizes[j];
            }
            else {
                ids[i] = j;
                sizes[j] += sizes[i];
            }
        }
        
        public void union(int p) {
            union(p, n);
        }
    }
    
    private int ROW;
    private int COL;
    
    public int[] hitBricks(int[][] grid, int[][] hits) {
        ROW = grid.length;
        COL = grid[0].length;
        
        Set<Integer> top = new HashSet<>();
        
        for (int j = 0; j < COL; j++)
            if (grid[0][j] == 1) top.add(j);
        
        UnionFind unionFind = new UnionFind(ROW * COL);
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> tempMap;
        
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1) {
                    if (top.contains(index(i, j)))
                        unionFind.union(i * COL + j);
                    else for (int k = 0; k < DIR.length; k++) {
                        int r = i + DIR[k][0];
                        int c = j + DIR[k][1];
                        if (valid(r, c) && grid[r][c] == 1)
                            unionFind.union(i * COL + j, r * COL + c);
                    }
                }
            }
        }
        
        int id = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (unionFind.isConnectToTop(index(i, j)))
                    map.put(index(i, j), id++);
                else grid[i][j] = 0;
            }
        }
        int count = map.size();
        
        int[] result = new int[hits.length];
        
        for (int i = 0; i < hits.length; i++) {
            int r = hits[i][0];
            int c = hits[i][1];
            boolean isConnectToTop = map.containsKey(index(r, c));
            grid[r][c] = 0;
            
            unionFind = new UnionFind(count);
            for (int key: map.keySet()) {
                r = getRow(key);
                c = getCol(key);
                if (grid[r][c] == 1) {
                    if (top.contains(key)) unionFind.union(map.get(key));
                    else for (int k = 0; k < DIR.length; k++) {
                        int rr = r + DIR[k][0];
                        int cc = c + DIR[k][1];
                        if (valid(rr, cc) && grid[rr][cc] == 1) {
                            unionFind.union(map.get(index(r, c)), map.get(index(rr, cc)));
                        }
                    }
                }
            }
            
            tempMap = new HashMap<>();
            id = 0;
            for (int key: map.keySet()) {
                int rr = getRow(key);
                int cc = getCol(key);
                if (unionFind.isConnectToTop(map.get(key)))
                    tempMap.put(key, id++);
                else grid[rr][cc] = 0;
            }
            map = tempMap;
            
            result[i] = isConnectToTop ? count - map.size() - 1 : 0;
            count = map.size();
        }
        return result;
    }
    
    private int index(int r, int c) {
        return r * COL + c;
    }
    
    private int getRow(int index) {
        return index / COL;
    }
    
    private int getCol(int index) {
        return index % COL;
    }
    
    private boolean valid(int r, int c) {
        return r >= 0 && r < ROW && c >= 0 && c < COL;
    }
    
    public static void main(String[] args) {
        for (int i: new Solution().hitBricks(new int[][] {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 1, 0},
                {1, 0, 1, 1}
        }, new int[][] {
                {3, 2},
                {2, 1},
                {1, 1},
                {1, 0}
        })) System.out.println(i);
        System.out.println();
        for (int i: new Solution().hitBricks(new int[][] {
                {1},
                {1},
                {1},
                {1},
                {1}
        }, new int[][] {
                {3, 0},
                {4, 0},
                {1, 0},
                {2, 0},
                {0, 0}
        })) System.out.println(i);
    }
}