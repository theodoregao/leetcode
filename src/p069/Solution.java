package p069;
class Solution {
    public int mySqrt(int x) {
        long lo = 0, hi = x;
        while (lo < hi) {
            long mid = (lo + hi) >> 1;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) return (int) mid;
            else if (mid * mid > x) hi = mid - 1;
            else lo = mid + 1;
        }
        return (int) lo;
    }
    
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++)
//            System.out.println(i + ": " + new Solution().mySqrt(i));
        
        System.out.println(new Solution().mySqrt(2147395599));
    }
}