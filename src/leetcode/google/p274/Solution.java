package leetcode.google.p274;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i)
                return n - i;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new Solution().hIndex(new int[]{100}));
    }
}