package p260;
public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int n: nums) xor ^= n;
        int lastBit = xor &= -xor;
        
        int[] result = new int[2];
        for (int n: nums) {
            if ((n & lastBit) != 0) result[0] ^= n;
            else result[1] ^= n;
        }
        return result;
    }
}