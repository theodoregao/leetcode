package p292;
public class Solution {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
    
    public boolean canWinNimDp(int n) {
        Boolean[] canWin = new Boolean[n + 1];
        canWin[0] = false;
        return canWinNim(canWin, n);
    }
    
    private boolean canWinNim(Boolean[] canWin, int n) {
        if (canWin[n] != null) return canWin[n];
        return canWin[n] = !(canWinNim(canWin, n - 1) && canWinNim(canWin, n - 2) && canWinNim(canWin, n - 3));
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) System.out.println(new Solution().canWinNim(i));
    }
}