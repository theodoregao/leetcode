package p042;

import java.util.Stack;

public class Solution {
//    public int trap(int[] height) {
//        if (height.length == 0) return 0;
//        int max = 0;
//        for (int i = 1; i < height.length; i++) if (height[max] < height[i]) max = i;
//        
//        int[] left = new int[max + 1];
//        for (int i = 0; i <= max; i++) left[i] = height[i];
//        
//        int[] right = new int[height.length - max];
//        for (int i = 0, j = height.length - 1; i < right.length; i++, j--) right[i] = height[j];
//        
//        return calculateTrap(left) + calculateTrap(right);
//    }
//    
//    private int calculateTrap(int[] height) {
//        if (height.length <= 1) return 0;
//        Stack<Integer> stack = new Stack<>();
//        int sum = 0;
//        int maxHeight = height[0];
//        int h;
//        
//        for (int i = 0; i < height.length; i++) {
//            h = height[i];
//            if (stack.isEmpty() || maxHeight >= h) stack.push(i);
//            else {
//                while(!stack.isEmpty()) sum += maxHeight - height[stack.pop()];
//                stack.push(i);
//                maxHeight = h;
//            }
//        }
//        while(!stack.isEmpty()) sum += maxHeight - height[stack.pop()];
//        
//        return sum;
//    }
    
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int sum = 0;
        int maxLeft = height[0], maxRight = height[height.length - 1];
        for (int i = 0, j = height.length - 1; i < j; ) {
            if (height[i] < height[j]) {
                i++;
                if (height[i] > maxLeft) maxLeft = height[i];
                else sum += maxLeft - height[i];
            }
            else {
                j--;
                if (height[j] > maxRight) maxRight = height[j];
                else sum += maxRight - height[j];
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[] {0,1,0,2,1,0,1,3,2,1,3,2,1,2,1}));
    }
}