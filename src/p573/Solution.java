package p573;
public class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int distance = 0;
        int[][] distances = new int[nuts.length][2];
        for (int i = 0; i < nuts.length; i++) {
            distances[i][0] += Math.abs(nuts[i][0] - tree[0]);
            distances[i][0] += Math.abs(nuts[i][1] - tree[1]);
            distance += distances[i][0];
            distances[i][1] += Math.abs(squirrel[0] - nuts[i][0]);
            distances[i][1] += Math.abs(squirrel[1] - nuts[i][1]);
        }
        int minDistance = Integer.MAX_VALUE;
        int curDistance = 0;
        for (int i = 0; i < distances.length; i++) {
            curDistance = 2 * distance - distances[i][0] + distances[i][1];
            minDistance = Math.min(minDistance, curDistance);
        }
        return minDistance;
    }
}