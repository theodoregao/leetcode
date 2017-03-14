package p137;
public class Solution {
    public int singleNumber(int[] nums) {
        /*
         * ab n/n ab/ab
         * 00 1/0 01/00
         * 01 1/0 10/01
         * 10 1/0 00/10
         * 
         * next a = !abc + a!b!c
         * next b = !a!bc + !ab!c
         * 
         * need the one only appear once as 01
         */
        int a = 0, b = 0, t = 0;
        for (int n: nums) {
            t = (~a&b&n) | (a&~b&~n);
            b = (~a&~b&n) | (~a&b&~n);
            a = t;
        }
        // need the one only appear once as 01
        return b;
    }
}