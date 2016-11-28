package p015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i = nextPos(nums, i)) {
            for (int j = i + 1; j < nums.length; j++) {
                int pos = Arrays.binarySearch(nums, j + 1, nums.length, -nums[i] - nums[j]);
                if (pos >= 0) set.add(makeTriplet(new int[] {nums[i], nums[j], -nums[i] - nums[j]}));
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> lst: set) list.add(lst);
        return list;
    }
    
    private List<Integer> makeTriplet(int[] nums) {
        Arrays.sort(nums);
        List<Integer> triplet = new ArrayList<>();
        triplet.add(nums[0]);
        triplet.add(nums[1]);
        triplet.add(nums[2]);
        return triplet;
    }
    
    private int nextPos(int[] nums, int i) {
        for (int j = i + 1; j < nums.length; j++)
            if (nums[j] != nums[i]) return j;
        return nums.length;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[] {0, 0, 0, 0}));
    }
}