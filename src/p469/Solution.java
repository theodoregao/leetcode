package p469;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        if (check(points)) return true;
        List<List<Integer>> reverse = new ArrayList<>();
        for (int i = points.size() - 1; i >= 0; i--) reverse.add(points.get(i));
        return check(reverse);
    }
    
    private boolean check(List<List<Integer>> points) {
        int n = points.size();
        for (int i = 0; i < n; i++) {
            if (!ccs(points.get((n + i - 2) % n), points.get((n + i - 1) % n), points.get(i))) return false;
        }
        return true;
    }
    
    private boolean ccs(List<Integer> p0, List<Integer> p1, List<Integer> p2) {
        return (p1.get(0) - p0.get(0)) * (p2.get(1) - p0.get(1))
                - (p1.get(1) - p0.get(1)) * (p2.get(0) - p0.get(0)) >= 0;
    }
}