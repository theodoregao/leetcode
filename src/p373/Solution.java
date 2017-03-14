package p373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return -o1[0] + o2[0] - o1[1] + o2[1];
            }
        });
        
        for (int i = 0; i < nums1.length; i++)
            for (int j = 0; j < nums2.length; j++) {
                priorityQueue.add(new int[] {nums1[i], nums2[j]});
                if (priorityQueue.size() > k) priorityQueue.poll();
            }
        
        while (priorityQueue.size() > 0) {
            list.add(0, priorityQueue.poll());
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        for (int[] v: new Solution().kSmallestPairs(new int[] {1,7,11}, new int[] {2,4,6}, 3)) {
            for (int i: v) System.out.println(i);
            System.out.println();
        }
    }
}