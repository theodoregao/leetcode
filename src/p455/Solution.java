package p455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = 0;
        for (int i = 0, j = 0; i < s.length && j < g.length; i++)
            if (s[i] >= g[j]) {
                n++;
                j++;
            }
        return n;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findContentChildren(new int[] {1,2,3}, new int[] {1,1}));
        System.out.println(new Solution().findContentChildren(new int[] {1,2}, new int[] {1,2,3}));
        System.out.println(new Solution().findContentChildren(new int[] {10,9,8,7}, new int[] {5,6,7,8}));
    }
}