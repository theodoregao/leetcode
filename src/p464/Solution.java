package p464;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        Map<Integer, Boolean> wins = new HashMap<>();
        int n = (int) Math.pow(2, maxChoosableInteger) - 1;
        return dp(wins, maxChoosableInteger, n, desiredTotal);
    }
    
    private boolean dp(Map<Integer, Boolean> wins, int max, int n, int total) {
        if (getTotal(n, max) < total) {
            wins.put(n, false);
            return false;
        }
        if (total <= 0) return true;
        if (wins.get(n) != null) return wins.get(n);
        boolean win = false;
        for (int i = 1; i <= max && !win; i++) if (get(n, i)) {
            if (total - i <= 0) win = true;
            else win = !dp(wins, max, reset(n, i), total - i);
        }
        wins.put(n, win);
//        System.out.println(n + ", " + total + ": " + win);
        return wins.get(n);
    }
    
    public boolean get(int n, int k) {
        return (n & (0x01 << k - 1)) != 0;
    }
    
    public int reset(int n, int k) {
        return n & ~(0x01 << k - 1);
    }
    
    public int getTotal(int n, int max) {
        int total = 0;
        for (int i = 1; i <= max; i++) total += get(n, i) ? i : 0;
        return total;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canIWin(10, 11));
        System.out.println(new Solution().canIWin(10, 10));
        System.out.println(new Solution().canIWin(4, 5));
        System.out.println(new Solution().canIWin(4, 6));
        System.out.println(new Solution().canIWin(4, 7));
        System.out.println(new Solution().canIWin(10, 40));
        System.out.println(new Solution().canIWin(5, 50));
    }
}