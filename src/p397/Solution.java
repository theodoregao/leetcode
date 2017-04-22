package p397;
public class Solution {
    public int integerReplacement(int n) {
        return recursive(n, 0);
    }
    
    private int recursive(long n, int k) {
        if (n == 1) return k;
        if (n % 2 == 0) return recursive(n / 2, k + 1);
        return Math.min(recursive(n + 1, k + 1), recursive(n - 1, k + 1));
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().integerReplacement(8));
        System.out.println(new Solution().integerReplacement(7));
        System.out.println(new Solution().integerReplacement(2147483647));
    }
}