package p256;
public class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0) return 0;
        int[] curCost = new int[3];
        int[] cost = new int[3];
        cost[0] = costs[0][0];
        cost[1] = costs[0][1];
        cost[2] = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < 3; j++) {
                curCost[0] = Math.min(cost[1], cost[2]) + costs[i][0];
                curCost[1] = Math.min(cost[0], cost[2]) + costs[i][1];
                curCost[2] = Math.min(cost[0], cost[1]) + costs[i][2];
            }
            cost[0] = curCost[0];
            cost[1] = curCost[1];
            cost[2] = curCost[2];
        }
        
        return min(cost[0], cost[1], cost[2]);
    }
    
    private static int min(int a, int b, int c) {
        return a < b && a < c ? a : (b < c ? b : c);
    }
}