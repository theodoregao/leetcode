package p461;
public class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            count += (x & 1) ^ (y & 1);
            x >>>= 1;
            y >>>= 1;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(1, 4));
    }
}