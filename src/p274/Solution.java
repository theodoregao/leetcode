package p274;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int h = n; h > 0; h--) {
//            System.out.println(h + ": " + (n - h) + ": " + citations[n - h]);
            if (h <= citations[n - h]) return h;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().hIndex(new int[] {3, 0, 6, 1, 5}));
        System.out.println(new Solution().hIndex(new int[] {0}));
        System.out.println(new Solution().hIndex(new int[] {1}));
    }
}