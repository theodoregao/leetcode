package p465;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	private int minCount;
    public int minTransfers(int[][] transactions) {
    	minCount = Integer.MAX_VALUE;
        Map<Integer, Integer> debts = new HashMap<>();
        
        for (int[] transaction: transactions) {
        	if (!debts.containsKey(transaction[0])) debts.put(transaction[0], 0);
        	if (!debts.containsKey(transaction[1])) debts.put(transaction[1], 0);
        	debts.put(transaction[0], debts.get(transaction[0]) + transaction[2]);
        	debts.put(transaction[1], debts.get(transaction[1]) - transaction[2]);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (Integer key: debts.keySet()) list.add(debts.get(key));
//        for (int i = debts.size() - 1; i >= 0; i--) if (list.get(i) == 0) list.remove(i);
        
        int[] values = new int[list.size()];
        for (int i = 0; i < values.length; i++) values[i] = list.get(i);
        
        int count = 0;
        Arrays.sort(values);
        for (int i = 0; i < values.length; i++) {
        	int index = Arrays.binarySearch(values, -values[i]);
        	if (index >= 0) {
        		if (values[i] != 0) count++;
        		values[i] = values[index] = 0;
        	}
        }
        
        int length = 0;
        for (int v: values) if (v != 0) length++;
        
        int[] noZeroValues = new int[length];
        for (int i = 0, j = 0; i < values.length; i++)
        	if (values[i] != 0) noZeroValues[j++] = values[i];
        
        for (int v: noZeroValues) System.out.println(v);
        
        return solve(noZeroValues, count);
    }
    
    private int solve(int[] values, int count) {
    	if (count >= minCount) return minCount;
    	if (values.length == 0) return count;
    	
    	Arrays.sort(values);
    	
    	int currentCount = Integer.MAX_VALUE;
    	for (int i = 0; i < values.length; i++) {
    		for (int j = i + 1; j < values.length; j++) {
    			if (values[i] == -values[j]) {
    				int[] newValues = new int[values.length - 2];
    				for (int k = 0, m = 0; k < values.length; k++)
    					if (k == i || k == j) continue;
    					else newValues[m++] = values[k];
    				return solve(newValues, count + 1);
    			}
    			else if (values[i] > 0) continue;
    			else {
    				int[] newValues = new int[values.length - 1];
    				for (int k = 0, m = 0; k < values.length; k++)
    					if (k == i || k == j) continue;
    					else newValues[m++] = values[k];
    				newValues[newValues.length - 1] = values[i] + values[j];
    				currentCount = Math.min(currentCount, solve(newValues, count + 1));
    			}
    		}
    	}
    	
//    	System.out.print("values: ");
//    	for (Integer v: values) System.out.print(v + " ");
//    	System.out.println();
//    	System.out.println(count + " vs " + currentCount);
    	
    	return minCount = Math.min(minCount, currentCount);
    }
    
    public static void main(String[] args) {
		int[][] transactions = new int[][] {
//			{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}
//			{0, 1, 1}, {1, 2, 1}, {2, 0, 1}
//			{0, 1, 1}, {1, 2, 1}, {2, 3, 4}, {3, 4, 5}
//			{1,2,3},{1,3,3},{6,4,1},{5,4,4}
//			{1,8,1},{1,13,21},{2,8,10},{3,9,20},{4,10,61},{5,11,61},{6,12,59},{7,13,60}
			{0,1,10},{1,0,1},{1,2,5},{2,0,5}
		};
		
		System.out.println(new Solution().minTransfers(transactions));
	}
}