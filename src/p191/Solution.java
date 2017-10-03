package p191;
public class Solution {
    // you need to treat n as an unsigned value
//    public int hammingWeight(int n) {
//        int count = 0;
//        while (n != 0) {
//            count += n & 1;
//            n >>>= 1;
//        }
//        return count;
//    }
    
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(512));
        System.out.println(new Solution().hammingWeight(513));
        System.out.println(new Solution().hammingWeight(1024));
//        System.out.println(new Solution().hammingWeight(4294967295);
        System.out.println(new Solution().hammingWeight(Integer.MAX_VALUE));
        System.out.println(new Solution().hammingWeight(Integer.MIN_VALUE + 1));
        System.out.println(new Solution().hammingWeight(Integer.MIN_VALUE + 2));
        System.out.println(new Solution().hammingWeight(-1));
    }
}