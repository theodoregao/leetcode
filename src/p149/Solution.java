package p149;

import java.util.HashMap;
import java.util.Map;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

class Solution {
    public int maxPoints(Point[] points) {
        Map<Map<Integer, Integer>, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Point pt = points[i];
            int duplicate = 1;
            map.clear();
            for (int j = i + 1; j < points.length; j++) {
                if (pt.x == points[j].x && pt.y == points[j].y) {
                    duplicate++;
                    continue;
                }
                int dx = points[j].x - pt.x;
                int dy = points[j].y - pt.y;
                int gcd = gcd(dx, dy);
                Map<Integer, Integer> slope = new HashMap<>();
                slope.put(dx / gcd, dy / gcd);
                map.put(slope, map.getOrDefault(slope, 0) + 1);
            }
            res = Math.max(res, duplicate);
            for (Map<Integer, Integer> key: map.keySet())
                res = Math.max(res, map.get(key) + duplicate);
        }
        return res;
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}