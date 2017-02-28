package p134;
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int n = gas.length;
    	boolean able = false;
    	int i = 0;
    	int remaining;
        for (i = 0; i < n && !able; i++) {
        	remaining = gas[i] - cost[i];
        	for (int j = 0; j < n && remaining >= 0; j++) {
        		remaining += gas[(i + j) % n] - cost[(i + j) % n];
        	}
        	if (remaining >= 0) {
        		able = true;
        		break;
        	}
        }
        return able ? i : -1;
    }
}