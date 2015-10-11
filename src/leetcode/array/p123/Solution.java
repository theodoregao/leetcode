package leetcode.array.p123;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        
        int n = prices.length;
        
        // ��ǰ����������
        int[] leftProfits = new int[n];
        int leftMin = prices[0];
        for (int i = 1; i < n; i++) {
            leftMin = Math.min(leftMin, prices[i]);
            leftProfits[i] = Math.max(leftProfits[i - 1], prices[i] - leftMin);
        }
        
        // �Һ�����������
        int[] rightProfits = new int[n];
        int rightMax = prices[n - 1];
        for (int i = n - 1; i > 0; i--) {
            rightMax = Math.max(rightMax, prices[i - 1]);
            rightProfits[i - 1] = Math.max(rightProfits[i], rightMax - prices[i - 1]);
        }
        
        // �ۺϽ�
        int maxProfits = 0;
        for (int i = 0; i < prices.length; i++)
            maxProfits = Math.max(maxProfits, leftProfits[i] + rightProfits[i]);
        
        return maxProfits;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {1, 2, 3, 4, 1, 2, 3, 4, 1, 2}));
    }
}