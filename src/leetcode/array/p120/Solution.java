package leetcode.array.p120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] sum = new int[triangle.size() + 1];
        for (int i = 0; i < sum.length; i++) sum[i] = Integer.MAX_VALUE;
        sum[1] = 0;
        
        for (int i = 1; i <= triangle.size(); i++) {
            List<Integer> row = triangle.get(i - 1);
            for (int j = 1; j <= i; j++) {
                row.set(j - 1, row.get(j - 1) + Math.min(sum[j - 1], sum[j]));
            }
            for (int j = 1; j <= i; j++) sum[j] = row.get(j - 1);
        }
        
        int min = sum[0];
        for (int i = 1; i < sum.length; i++) min = Math.min(min, sum[i]);
        
        return min;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new Solution().minimumTotal(triangle));
    }
}