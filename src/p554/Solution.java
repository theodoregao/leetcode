package p554;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int height = 0;
        int width = 0;
        for (List<Integer> row: wall) {
            height++;
            int length = 0;
            for (int brick: row) {
                length += brick;
                if (!map.containsKey(length)) map.put(length, 0);
                map.put(length, map.get(length) + 1);
            }
            width = length;
        }
        int max = 0;
        for (int sz: map.keySet()) {
            if (sz != width) max = Math.max(max, map.get(sz));
        }
        return height - max;
    }
}