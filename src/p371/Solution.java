package p371;
public class Solution {
    public int getSum(int a, int b) {
        boolean carry = false;
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            boolean ai = get(a, i);
            boolean bi = get(b, i);
            if ((!carry && !ai && bi) || (!carry && ai && !bi) || (carry && !ai && !bi) || (carry && ai && bi)) result = set(result, i);
            carry = (carry && ai && bi) || (carry && ai && !bi) || (carry && !ai && bi) || (!carry && ai && bi);
        }
        return result;
    }
    
    private boolean get(int n, int index) {
        return (n & (0x01 << index)) != 0;
    }
    
    private int set(int n, int index) {
        return n | (0x01 << index);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getSum(1, 2));
        System.out.println(new Solution().getSum(111, 222));
        System.out.println(new Solution().getSum(2, 2));
        System.out.println(new Solution().getSum(15753416, 1111111));
    }
}