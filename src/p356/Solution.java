package p356;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isReflected(int[][] points) {
        
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        
        Set<String> set = new HashSet<>();
        
        for (int[] point: points) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
            set.add(point[0] + "-" + point[1]);
        }
        
        int x = minX + maxX;
        
        for (int[] point: points)
            if (!set.contains((x - point[0]) + "-" + point[1])) return false;

        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isReflected(new int[][] {
                {1, 1}, {-1, 1}, {2, 0}, {-2, 0}, {-2, 0}
        }));
    }
}