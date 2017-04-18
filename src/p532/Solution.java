package p532;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            if (!map.containsKey(n)) map.put(n, 0);
            map.put(n, map.get(n) + 1);
        }
        
        int count = 0;
        
        for (int key: map.keySet()) {
            if (k == 0) {
                if (map.get(key) > 1) count += 2;
            }
            else {
                if (map.containsKey(key + k)) count++;
                if (map.containsKey(key - k)) count++;
            }
        }
        
        return count / 2;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findPairs(new int[] {1,2,2,1,34,2,3,4,5,6,2,3,3,1}, 0));
    }
}