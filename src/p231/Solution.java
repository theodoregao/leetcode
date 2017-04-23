package p231;
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count == 1;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i <= 17; i++) System.out.println(i + ": " + new Solution().isPowerOfTwo(i));
    }
}