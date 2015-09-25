package leetcode.facebook.p121;
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int min = prices[0];
        int maxProfile = 0;
        
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfile = Math.max(prices[i] - min, maxProfile); 
        }
        
        return maxProfile;
    }
}