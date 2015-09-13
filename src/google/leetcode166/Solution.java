package google.leetcode166;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Theodore
 *
 *  注意负数（分子跟分母都可能是负数），还需要注意溢出
 */
public class Solution {
    public String fractionToDecimal(int num, int den) {
        
        long numerator = num;
        long denominator = den;
        String s = 1.0 * numerator / denominator < 0 ? "-" : "";
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        
        s += numerator / denominator;
        numerator %= denominator;
        if (numerator != 0) s += ".";
        
        String fractional  = "";
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while (numerator!= 0 && !map.containsKey(numerator)) {
            map.put(numerator, fractional.length());
            numerator *= 10;
            fractional += numerator / denominator;
            numerator %= denominator;
        }
        
        if (numerator == 0) return s + fractional;
        else {
            s += fractional.substring(0, map.get(numerator));
            return s + "(" + fractional.substring(map.get(numerator)) + ")";
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(1, 2));
        System.out.println(new Solution().fractionToDecimal(2, 1));
        System.out.println(new Solution().fractionToDecimal(2, 3));
        System.out.println(new Solution().fractionToDecimal(20, 3));
        System.out.println(new Solution().fractionToDecimal(-50, 8));
        System.out.println(new Solution().fractionToDecimal(-50, -3));
        System.out.println(new Solution().fractionToDecimal(-1, -2147483648));
    }
}