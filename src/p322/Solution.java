package p322;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int[] counts = new int[amount + 1];
        for (int i = 1; i <= amount; i++) counts[i] = Integer.MAX_VALUE / 2;
        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j <= amount; j++)
                counts[j] = Math.min(counts[j - coins[i]] + 1, counts[j]);
        return counts[amount] == Integer.MAX_VALUE / 2 ? -1 : counts[amount];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[] {2}, 1));
    }
}