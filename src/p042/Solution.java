package p042;

public class Solution {

//    public int trap(int[] height) {
//        if (height.length <= 2) return 0;
//        int[] rightHeight = new int[height.length];
//        int maxHeight = 0;
//        for (int i = height.length - 1; i >= 0; i--) {
//            rightHeight[i] = maxHeight;
//            maxHeight = Math.max(maxHeight, height[i]);
//        }
//        int leftHeight = height[0];
//        int res = 0;
//        for (int i = 1; i < height.length; i++) {
//            if (height[i] < rightHeight[i] && height[i] < leftHeight)
//                res += Math.min(rightHeight[i], leftHeight) - height[i];
//            leftHeight = Math.max(leftHeight, height[i]);
//        }
//        return res;
//    }
    

    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        
        int n = height.length;
        int left = height[0];
        int right = height[n - 1];
        int res = 0;
        
        for (int i = 0, j = n - 1; i < j; ) {
            if (height[i] <= height[j]) {
                if (left > height[i] && right > height[i]) res += Math.min(left, right) - height[i];
                left = Math.max(left, height[i++]);
            }
            else {
                if (left > height[j] && right > height[j]) res += Math.min(left, right) - height[j];
                right = Math.max(right, height[j--]);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new Solution().trap(new int[] {2,0,2}));
    }
}