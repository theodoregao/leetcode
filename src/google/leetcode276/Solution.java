package google.leetcode276;

public class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        if (n == 1) return k;
        
        int[] ways = new int[n + 1];
        ways[1] = k;
        ways[2] = k * k;
        
        for (int i = 3; i <= n; i++) {
            ways[i] = ways[i - 1] * (k - 1) + ways[i - 2] * (k - 1);
        }
        
        return ways[n];
    }
    
    public static void main(String[] args) {
        for (int n = 1; n < 6; n++) {
            for (int k = 1; k < 4; k++) {
                System.out.println(n + ", " + k + " : " + new Solution().numWays(n, k));
            }
        }
    }
}