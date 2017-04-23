package p372;
public class Solution {
    
    private int[] b;
    
    public int superPow(int a, int[] b) {
        this.b = b;
        if (zero()) return 0;
        long da = a;
        int ans = 1;
        while (!zero()) {
            if (divideByTwo()) ans = (int) ((ans * da) % 1337);
            da = (da * da) % 1337;
        }
        return ans;
    }
    
    private boolean zero() {
        for (int i = 0; i < b.length; i++) if (b[i] != 0) return false;
        return true;
    }
    
    private boolean divideByTwo() {
        int carry = 0;
        for (int i = 0; i < b.length; i++) {
            b[i] += carry * 10;
            carry = b[i] % 2;
            b[i] /= 2;
        }
        return carry != 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().superPow(2, new int[] {8}));
        System.out.println(new Solution().superPow(2, new int[] {9}));
        System.out.println(new Solution().superPow(2, new int[] {1,0}));
        System.out.println(new Solution().superPow(2, new int[] {1,1}));
        System.out.println(new Solution().superPow(2, new int[] {1,2}));
        System.out.println(new Solution().superPow(2, new int[] {1,3}));
        System.out.println(new Solution().superPow(2147483647, new int[] {2,0,0}));
    }
}