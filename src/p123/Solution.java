package p123;
class Solution {
    public int maxProfit(int[] prices) {
        return maxKProfit(2, prices);
    }
    
    // check leetcode 188
    public int maxProfitSlowDp(int k, int[] prices) {
        // 不需要循环k次
        if (prices == null || prices.length < 2) return 0;
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < prices.length; j++) {
                int max = 0;
                // 这个耗时太多了
                // 以i = 2. j = 3, 4
                // max(2, 3) = max {prices[3] - prices[0] + dp[1][0],
                //                  prices[3] - prices[1] + dp[1][1],
                //                  prices[3] - prices[2] + dp[1][2] }
                //
                // max(2, 4) = max {prices[4] - prices[0] + dp[1][0],
                //                  prices[4] - prices[1] + dp[1][1],
                //                  prices[4] - prices[2] + dp[1][2],
                //                  prices[4] - prices[3] + dp[1][3] }
                //
                // each time check dp[i - 1][j] - prices[j - 1], define as dif
                //
                for (int m = 0; m < j; m++)
                    max = Math.max(max, prices[j] - prices[m] + dp[i - 1][m]);
                
                // 内存用量过大，从没访问两行之前的数据
                dp[i][j] = Math.max(dp[i][j - 1], max);
            }
        }
        return dp[k][prices.length - 1];
    }
    
    public int maxKProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        k = Math.min(k, prices.length / 2);
        int[] dp = new int[prices.length];
        int[] dpTemp = new int[prices.length];
        int[] temp;
        for (int i = 1; i <= k; i++) {
            temp = dp; dp = dpTemp; dpTemp = temp;
            int dif = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                dif = Math.max(dif, dpTemp[j - 1] - prices[j - 1]);
                dp[j] = Math.max(dp[j - 1], prices[j] + dif);
            }
        }
        return dp[prices.length - 1];
    }
}