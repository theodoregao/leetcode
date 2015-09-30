package leetcode.facebook.p253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {

        int size = intervals.length;
        if (size <= 1) return size;
        
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval left, Interval right) {
                return left.start - right.start;
            }
        };
        
        Arrays.sort(intervals, comparator);
        
        int count = 1;
        Set<Interval> rooms = new HashSet<Interval>();
        rooms.add(intervals[0]);
        for (int i = 1; i < size; i++) {
            removeEnds(rooms, intervals[i]);
            rooms.add(intervals[i]);
            count = Math.max(count, rooms.size());
        }
        
        return count;
    }
    
    private void removeEnds(Set<Interval> rooms, Interval meeting) {
        Set<Interval> removes = new HashSet<Interval>();
        for (Interval room: rooms) {
            if (room.end <= meeting.start) removes.add(room);
        }
        rooms.removeAll(removes);
    }
    
    public static void main(String[] args) {
        Interval[] intervals = new Interval[] {
                new Interval(5, 8),
                new Interval(6, 8),
                new Interval(1, 10),
                new Interval(2, 5)};
        System.out.println(new Solution().minMeetingRooms(intervals));
    }
}