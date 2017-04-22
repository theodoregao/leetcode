package p190;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        StringBuffer sb = new StringBuffer(Integer.toBinaryString(n));
        String binaryReverse = sb.reverse().toString();
        byte[] bytes = new byte[32];
        for (int i = 0; i < binaryReverse.length(); i++) if (binaryReverse.charAt(i) == '1') bytes[31 - i] = 1;
        reverse(bytes);
//        for (byte b: bytes) System.out.println(b);
        int k = 0;
        for (int i = 0; i < bytes.length; i++) if (bytes[i] == 1) k = set(k, 31 - i);
        return k;
    }
    
    private void reverse(byte[] bytes) {
        for (int i = 0, j = bytes.length - 1; i < j; i++, j--) {
            byte b = bytes[i];
            bytes[i] = bytes[j];
            bytes[j] = b;
        }
    }
    
    private int set(int n, int i) {
        return n | (1 << i);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(43261596));
        System.out.println(new Solution().reverseBits(0));
        System.out.println(new Solution().reverseBits(-1));
        System.out.println(new Solution().reverseBits(Integer.MAX_VALUE));
        System.out.println(new Solution().reverseBits(Integer.MIN_VALUE));
    }
}