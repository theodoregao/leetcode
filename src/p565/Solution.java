package p565;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int arrayNesting(int[] nums) {
        UnionFind unionFind = new UnionFind(nums.length);
        for (int i = 0; i < nums.length; i++) unionFind.union(i, nums[i]);
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(unionFind.find(nums[i]))) continue;
            set.add(unionFind.find(nums[i]));
            max = Math.max(max, travel(nums, i));
        }
        return max;
    }
    
    private int travel(int[] nums, int k) {
        int[] count = new int[nums.length];
        count[k] = 1;
        int n = 0;
        while (count[nums[k]] == 0) {
            count[nums[k]] = count[k] + 1;
            k = nums[k];
        }
//        System.out.println(count[k] + ": " + count[nums[k]]);
        return count[k] - count[nums[k]] + 1;
    }
    
    private static class UnionFind {
        private int count;
        private int[] ids;
        
        public UnionFind(int n) {
            count = n;
            ids = new int[n];
            for (int i = 0; i < n; i++) ids[i] = i;
        }
        
        public void union(int p, int q) {
            if (find(p) == find(q)) return;
            ids[find(q)] = find(p);
            count--;
        }
        
        public int find(int p) {
            if (p == ids[p]) return p;
            else return ids[p] = find(ids[p]);
        }
        
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
        
        public int count() {
            return count;
        }
    }
    
    public static void main(String[] args) {
//        System.out.println(new Solution().arrayNesting(new int[] {5,4,2,3,1,6,0}));
        System.out.println(new Solution().arrayNesting(new int[] {1,0,3,4,2}));
    }
}