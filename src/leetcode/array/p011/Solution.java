package leetcode.array.p011;

public class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        
        for (int i = 0, j = height.length - 1; i < j; ) {
            area = Math.max(area,  Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) j--; else i++;
        }
        
        return area;
    }
    
    public static void main(String[] args) {
        int height[] = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        
        System.out.println(new Solution().maxArea(height));
    }
}