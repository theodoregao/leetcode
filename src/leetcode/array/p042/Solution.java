package leetcode.array.p042;


public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        
        int sz = 0;
        
        int i = 0, j = height.length - 1;
        int next;
        
        while (i < j) {
            if (height[i] <= height[j]) {
                for (next = i; next < j && height[next] <= height[i]; next++) {/**/}
                sz += count(height, i, next);
                i = next;
            }
            else {
                for (next = j; next > i && height[next] <= height[j]; next--) {/**/}
                sz += count(height, next, j);
                j = next;
            }
        }
        
        return sz;
    }
    
    private int count(int[] height, int i, int j) {
        int count = 0;
        int max = Math.min(height[i], height[j]);
        for (j--; i < j; j--) count += max - height[j];
        return count;
    }
    
    public static void main(String[] args) {
        int[] height = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1, 4};
        System.out.println(new Solution().trap(height));
    }
}