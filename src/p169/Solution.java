package p169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {
    public int majorityElement(int[] nums) {
//    	return majorityElementHash(nums);
//    	return majorityElementRandom(nums);
//    	return majorityElementSort(nums);
//    	return majorityElementNSelect(nums);
//    	return majorityElementDivideAndConquer(nums);
    	return majorityElementMooreVoting(nums);
    }
    
    private int majorityElementHash(int[] nums) {
    	int count = nums.length / 2;
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int n: nums) {
    		if (!map.containsKey(n)) map.put(n, 0);
    		map.put(n, map.get(n) + 1);
    		if (map.get(n) > count) return n;
    	}
    	return 0;
    }
    
    private int majorityElementRandom(int[] nums) {
    	int count = nums.length / 2;
    	Random random = new Random();
    	while (true) {
    		int n = nums[random.nextInt(nums.length)];
    		int c = 0;
    		for (int candidate: nums)
    			if (candidate == n)
    				if (++c > count)
    					return candidate;
    	}
    }
    
    private int majorityElementSort(int[] nums) {
    	Arrays.sort(nums);
    	return nums[nums.length / 2];
    }
    
    private int majorityElementNSelect(int[] nums) {
    	return majorityElementNSelect(nums, 0, nums.length - 1);
    }
    
    private int majorityElementNSelect(int[] nums, int s, int e) {
    	if (s >= e) return nums[s];
    	int j = partition(nums, s, e);
    	if (j == nums.length / 2) return nums[j];
    	else if (j < nums.length / 2) return majorityElementNSelect(nums, j + 1, e);
    	else return majorityElementNSelect(nums, s, j - 1);
    }
    
    private int partition(int[] items, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (items[lo] > items[++i]) if (i >= hi) break;
            while (items[lo] < items[--j]) ;
            if (i >= j) break;
            swap(items, i, j);
        }
        swap(items, lo, j);
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    
    private int majorityElementDivideAndConquer(int[] nums) {
//    	return divideAndConquer(nums, 0, nums.length - 1);
    	return divideAndConquerHelper(nums, 0, nums.length - 1).v;
    }
    
    private int divideAndConquer(int[] nums, int lo, int hi) {
    	if (lo >= hi) return nums[lo];
    	int mid = (lo + hi) >>> 1;
    	int l = divideAndConquer(nums, lo, mid);
    	int r = divideAndConquer(nums, mid + 1, hi);
    	if (l == r) return l;
    	return count(nums, lo, mid, l) > count(nums, mid + 1, hi, r) ? l : r;
    }
    
    private DividAndConquerReturn divideAndConquerHelper(int[] nums, int lo, int hi) {
    	if (lo >= hi) return new DividAndConquerReturn(nums[lo], 1);
    	int mid = (lo + hi) >>> 1;
    	DividAndConquerReturn l = divideAndConquerHelper(nums, lo, mid);
    	DividAndConquerReturn r = divideAndConquerHelper(nums, mid + 1, hi);
    	if (l.v == r.v) return new DividAndConquerReturn(l.v, l.count + r.count);
    	if (l.count > r.count) return new DividAndConquerReturn(l.v, l.count + count(nums, mid + 1, hi, l.v));
    	else return new DividAndConquerReturn(r.v, r.count + count(nums, lo, mid, r.v));
    }
    
    private int count(int[] nums, int lo, int hi, int v) {
    	int count = 0;
    	for (int i = lo; i <= hi; i++)
    		if (v == nums[i])
    			count++;
    	return count;
    }
    
    private class DividAndConquerReturn {
    	int v;
    	int count;
    	
    	public DividAndConquerReturn(int v, int count) {
    		this.v = v;
    		this.count = count;
    	}
    }
    
    private int majorityElementMooreVoting(int[] nums) {
    	int count = 0;
    	int n = nums[0];
    	for (int num: nums) {
    		if (n == num) count++;
    		else if (--count == 0) {
    			n = num;
    			count = 1;
    		}
    	}
    	return n;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().majorityElement(new int[] {6, 5, 5}));
	}
}