package p172;
public class Solution {
    public int trailingZeroes(int n) {
        int k = 0;
        long m = 5;
        while (n >= m) {
            k += n / m;
            m *= 5;
        }
        return k;
    }
}