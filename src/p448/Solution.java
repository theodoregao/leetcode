package p448;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	int n = nums.length;
        for (int i = 0; i < n; i++) nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) if (nums[i] > 0) list.add(i + 1);
        return list;
    }
}