package p085;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int maxArea = 0;
        
        int[] heights = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == '0') heights[j] = 0;
                else heights[j]++;
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> sPositions = new Stack<>();
        Stack<Integer> sHeights = new Stack<>();
        int maxArea = 0;
        int lastPos = 0;
        int h = 0;
        
        for (int i = 0; i < heights.length; i++) {
            h = heights[i];
            if (sHeights.isEmpty() || sHeights.peek() < h) {
                sPositions.push(i);
                sHeights.push(h);
            }
            else if (sHeights.peek() > h) {
                while (!sHeights.isEmpty() && sHeights.peek() > h) {
                    lastPos = sPositions.pop();
                    maxArea = Math.max(maxArea, (i - lastPos) * sHeights.pop());
                }
                sPositions.push(lastPos);
                sHeights.push(h);
            }
        }
        
        while (!sHeights.isEmpty()) {
            lastPos = sPositions.pop();
            maxArea = Math.max(maxArea, (heights.length - lastPos) * sHeights.pop());
        }
        
        return maxArea;
    }
}