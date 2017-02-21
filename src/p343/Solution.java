package p343;
public class Solution {
    public int integerBreak(int n) {
        int[] maxs = new int[n + 1];
        
        for (int i = 2; i <= n; i++) for (int j = 1; j < i; j++) {
            maxs[i] = Math.max(maxs[i], Math.max(j, maxs[j]) * Math.max(i - j, maxs[i - j]));
        }
        
        return maxs[n];
    }
    
}