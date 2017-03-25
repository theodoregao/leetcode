package p218;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> list = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b: buildings) {
            height.add(new int[] {b[0], b[2]});
            height.add(new int[] {b[1], -b[2]});
        }
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int pre = 0;
        for (int[] h: height) {
            if (h[1] > 0) pq.offer(h[1]); else pq.remove(-h[1]);
            if (pre != pq.peek()) {
                list.add(new int[] {h[0], pq.peek()});
                pre = pq.peek();
            }
        }
        return list;
    }
}