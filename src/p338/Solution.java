package p338;
public class Solution {
    public int[] countBits(int num) {
        int[] counts = new int[num + 1];
        for (int i = 1; i <= num; i++) counts[i] = (i & 0x01) + counts[i >> 1];
        return counts;
    }
}