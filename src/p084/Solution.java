package p084;

import java.util.Stack;

public class Solution {
    
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> sPosition = new Stack<>();
        Stack<Integer> sHeight = new Stack<>();
        int maxArea = 0;
        int lastPos = 0;
        int h = 0;
        
        for (int i = 0; i < heights.length; i++) {
            h = heights[i];
            if (sHeight.isEmpty() || sHeight.peek() < h) {
                sPosition.push(i);
                sHeight.push(h);
                System.out.println(sPosition);
                System.out.println(sHeight);
                System.out.println();
            }
            else if (sHeight.peek() > h) {
                while (!sHeight.isEmpty() && sHeight.peek() > h) {
                    lastPos = sPosition.pop();
                    maxArea = Math.max(maxArea, (i - lastPos) * sHeight.pop());
                }
                sPosition.push(lastPos);
                sHeight.push(h);
//                System.out.println(lastPos + " " + h);
                System.out.println(sPosition);
                System.out.println(sHeight);
                System.out.println();
            }
        }
        
        while (!sPosition.isEmpty()) {
            System.out.println(sPosition);
            System.out.println(sHeight);
            System.out.println();
            lastPos = sPosition.pop();
            h = sHeight.pop();
//            System.out.println(lastPos + " " + h);
            maxArea = Math.max(maxArea, (heights.length - lastPos) * h);
        }
        
        return maxArea;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[] {2, 1, 2, 0, 1, 2}));
    }
    
}