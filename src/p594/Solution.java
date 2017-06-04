package p594;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n: nums) map.put(n, map.containsKey(n) ? map.get(n) + 1: 1);
        for (int n: map.keySet()) max = Math.max(max, (map.containsKey(n - 1) ? map.get(n - 1) : Integer.MIN_VALUE) + map.get(n));
        return max;
    }
}