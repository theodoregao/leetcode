package leetcode.facebook.p273;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    private static Map<Integer, String> ONES = new HashMap<Integer, String>();
    private static Map<Integer, String> TENS = new HashMap<Integer, String>();
    
    static {
        ONES.put(1, "One");
        ONES.put(2, "Two");
        ONES.put(3, "Three");
        ONES.put(4, "Four");
        ONES.put(5, "Five");
        ONES.put(6, "Six");
        ONES.put(7, "Seven");
        ONES.put(8, "Eight");
        ONES.put(9, "Nine");
        ONES.put(10, "Ten");
        ONES.put(11, "Eleven");
        ONES.put(12, "Twelve");
        ONES.put(13, "Thirteen");
        ONES.put(14, "Fourteen");
        ONES.put(15, "Fifteen");
        ONES.put(16, "Sixteen");
        ONES.put(17, "Seventeen");
        ONES.put(18, "Eighteen");
        ONES.put(19, "Nineteen");
        ONES.put(20, "Twenty");

        TENS.put(2, "Twenty");
        TENS.put(3, "Thirty");
        TENS.put(4, "Forty");
        TENS.put(5, "Fifty");
        TENS.put(6, "Sixty");
        TENS.put(7, "Seventy");
        TENS.put(8, "Eighty");
        TENS.put(9, "Ninety");
    }
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int ones = num % 1000;
        num /= 1000;
        int thousands = num % 1000;
        num /= 1000;
        int millions = num % 1000;
        int billions = num / 1000;
        
        StringBuffer sb = new StringBuffer();
        if (billions > 0) sb.append(toWord(billions)).append(" Billion ");
        if (millions > 0) sb.append(toWord(millions)).append(" Million ");
        if (thousands > 0) sb.append(toWord(thousands)).append(" Thousand ");
        if (ones > 0) sb.append(toWord(ones));
        
        return sb.toString().trim();
    }
    
    private String toWord(int num) {
        StringBuffer sb = new StringBuffer();
        int hundrends = num / 100;
        if (hundrends > 0)
            sb.append(ONES.get(hundrends)).append(" Hundred ");
        num %= 100;
        if (num > 0 && num <= 20)
            sb.append(ONES.get(num));
        if (num > 20) {
            sb.append(TENS.get(num / 10));
            if (num % 10 != 0) sb.append(" ").append(ONES.get(num % 10));
        }
        return sb.toString().trim();
    }
    
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int value = random.nextInt() % Integer.MAX_VALUE;
            if (value >= 0)
                System.out.println(value + ": " + new Solution().numberToWords(value));
        }
    }
}