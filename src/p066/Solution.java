package p066;
public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if (all9(digits)) {
            int[] result = new int[n + 1];
            result[0] = 1;
            return result;
        }
        int carry = 1;
        for (int i = n - 1; i >= 0 && carry != 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        return digits;
    }
    
    private boolean all9(int[] digits) {
        for (int i = 0; i < digits.length; i++) if (digits[i] != 9) return false;
        return true;
    }
}