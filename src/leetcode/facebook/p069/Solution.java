package leetcode.facebook.p069;
public class Solution {
    public int mySqrt(int x) {
        double left = 0;    // 起始值要注意为0
        double right = x;
        
        while (left < right) {
            double mid = (left + right) / 2;
            if (Math.abs(mid * mid - x) < 1e-6) return (int) (mid + 1e-6);
            else if (mid * mid > x) right = mid;
            else left = mid;
        }
        
        return (int) (left + 1e-6);
    }
    
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) System.out.println(i + " : " + new Solution().mySqrt(i));
    }
}