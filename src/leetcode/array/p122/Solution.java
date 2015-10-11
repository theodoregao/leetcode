package leetcode.array.p122;

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        
        if (prices.length == 0) return 0;
        
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                profit += prices[i] - min;
                min = prices[i];
            }
            else {
                min = Math.min(min, prices[i]);
            }
        }
        
        return profit;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {1, 2, 3, 4, 1, 2, 3, 4, 1, 2}));
    }
}