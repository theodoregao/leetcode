package p475;

import java.util.Arrays;

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int max = 0;
        Arrays.sort(heaters);
        for (int i = 0; i < houses.length; i++) {
        	int pos = Arrays.binarySearch(heaters, houses[i]);
    		int radius = 0;
        	if (pos < 0) {
        		radius = Integer.MAX_VALUE;
        		pos = -pos - 1;
        		if (pos < heaters.length)
        			radius = Math.min(radius, Math.abs(heaters[pos] - houses[i]));
        		if (pos - 1 >= 0)
        			radius = Math.min(radius, Math.abs(heaters[pos - 1] - houses[i]));
        	}
        	max = Math.max(radius, max);
        }
        return max;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().findRadius(
				new int[] {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923},
				new int[] {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612}));
	}
}