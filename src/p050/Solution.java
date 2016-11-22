package p050;

public class Solution {
    
    public double myPow(double x, int nn) {
        long n = nn;
        if (n == 0) return 1.0;

        boolean minus = n < 0;
        if (minus) n = -n;
        
        double v = 1.0;
        double xPow = x;
        long m = n;
        int k = 0;
        while (m > 0) {
            if (bit(n, k++)) v *= xPow;
            xPow *= xPow;
            m /= 2;
        }
        
        return minus ? 1.0 / v : v;
    }
    
    private boolean bit(long n, int k) {
        return ((0x01 << k) & n) != 0;
    }
    
    public static void main(String[] args) {
        for (int n = 0; n < 20; n++)
            System.out.println(new Solution().myPow(1.0, Integer.MIN_VALUE));
    }
    
}