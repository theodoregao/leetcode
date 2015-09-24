package leetcode.facebook.p050;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Long, Double> map;
    
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1.0;
        
        long k = n;
        
        if (k < 0) {
            x = 1.0 / x;
            k = -k;
        }
        
        map = new HashMap<Long, Double>();
        
        map.put(0L, 1.0);
        map.put(1L, x);
        
        dp(x, k);
        return map.get(k);
    }

    private double dp(double x, long n) {
        if (map.containsKey(n)) return map.get(n);
        map.put(n, map.get(n % 2) * dp(x, n / 2) * dp(x, n / 2));
        return map.get(n);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().myPow(1.01, 10000));
        System.out.println(new Solution().myPow(-1.01, 9999));
        System.out.println(new Solution().myPow(0.99, -9999));
        System.out.println(new Solution().myPow(1.0000001, 2147483647));
    }
}