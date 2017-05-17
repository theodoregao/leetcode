package p029;

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        boolean negtive = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        long result = recursive(ldividend, ldivisor);
        if (negtive) result = -result;
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) result;
    }
    
    private long recursive(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long rst = 1;
        while ((sum + sum) < ldividend) {
            rst += rst;
            sum += sum;
        }
        return rst + recursive(ldividend - sum, ldivisor);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().divide(1023, 51));
        System.out.println(new Solution().divide(Integer.MIN_VALUE, -1));
        System.out.println(new Solution().divide(Integer.MIN_VALUE, 1));
        System.out.println(new Solution().divide(Integer.MAX_VALUE, 1));
        System.out.println(new Solution().divide(Integer.MAX_VALUE, -1));
    }
}