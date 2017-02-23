package p452;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        Interval[] intervals = new Interval[points.length];
        Set<Interval> removals = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
        	intervals[i] = new Interval(points[i][0], points[i][1]);
        }
        Arrays.sort(intervals);
        int n = 0;
        for (int i = 0; i < intervals.length; i++) {
        	Interval interval = intervals[i];
        	if (!removals.contains(interval)) {
        		n++;
        		for (int j = i + 1; j < intervals.length; j++)
        			if (intervals[j].intersect(interval))
        				removals.add(intervals[j]);
        	}
        	removals.add(interval);
        }
        return n;
    }
    
    private static class Interval implements Comparable<Interval> {
    	int s, e;
    	Interval(int s, int e) {
    		this.s = s;
    		this.e = e;
    	}
    	
    	boolean intersect(Interval interval) {
    		return !(s > interval.e || e < interval.s);
    	}

		@Override
		public int compareTo(Interval interval) {
			return e - interval.e;
		}
		
		@Override
		public String toString() {
			return Interval.class.getSimpleName() + "[" + s + ", " + e + "]";
		}
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().findMinArrowShots(new int[][] {{1,2}, {3,4}, {5,6}, {7,8}}));
		System.out.println(new Solution().findMinArrowShots(new int[][] {{1,2}, {2,3}, {3,4}, {4,5}}));
		System.out.println(new Solution().findMinArrowShots(new int[][] {{0,9},{1,8},{7,8},{1,6},{9,16},{7,13},{7,10},{6,11},{6,9},{9,13}}));
	}
}