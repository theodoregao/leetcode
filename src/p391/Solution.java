package p391;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    
    public boolean isRectangleCover(int[][] rectangles) {
        
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        int area = 0;
        Set<Point> points = new HashSet<>();
        int x0, y0, x1, y1;
        
        for (int[] rectangle: rectangles) {
            x0 = rectangle[0];
            y0 = rectangle[1];
            x1 = rectangle[2];
            y1 = rectangle[3];
            
            minX = Math.min(minX, x0);
            minY = Math.min(minY, y0);
            maxX = Math.max(maxX, x1);
            maxY = Math.max(maxY, y1);

            if (!points.add(new Point(x0, y0))) points.remove(new Point(x0, y0));
            if (!points.add(new Point(x1, y1))) points.remove(new Point(x1, y1));
            if (!points.add(new Point(x0, y1))) points.remove(new Point(x0, y1));
            if (!points.add(new Point(x1, y0))) points.remove(new Point(x1, y0));
            
            area += (x1 - x0) * (y1 - y0);
        }

        if (points.size() != 4) return false;
        
        area -= (maxX - minX) * (maxY - minY);
        points.remove(new Point(minX, minY));
        points.remove(new Point(maxX, maxY));
        points.remove(new Point(minX, maxY));
        points.remove(new Point(maxX, minY));
        
        return area == 0 && points.isEmpty();
    }
    
    private static class Point {
        private int x;
        private int y;
        private int hashCode = 0;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) return false;
            Point other = (Point) obj;
            return other.x == x && other.y == y;
        }
        @Override
        public int hashCode() {
            if (hashCode != 0) return hashCode;
            hashCode += x;
            hashCode = hashCode * 97 + y;
            return hashCode;
        }
    }
    
}