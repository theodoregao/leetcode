package p286;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static int[][] DIR = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<Location> queue = new LinkedList<>();
        boolean[][] marked = new boolean[m][n];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (rooms[i][j] == 0) {
            queue.add(new Location(rooms, i, j, 0));
            marked[i][j] = true;
        }
        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int i = 0; i < DIR.length; i++) {
                Location neighbor = new Location(rooms, location.r + DIR[i][0], location.c + DIR[i][1], location.distance + 1);
                if (neighbor.valid() && !marked[neighbor.r][neighbor.c] && rooms[neighbor.r][neighbor.c] == Integer.MAX_VALUE) {
                    marked[neighbor.r][neighbor.c] = true;
                    rooms[neighbor.r][neighbor.c] = neighbor.distance;
                    queue.offer(neighbor);
                }
            }
        }
    }
    private static class Location {
        int[][] rooms;
        int r;
        int c;
        int distance;
        public Location(int[][] rooms, int r, int c, int distance) {
            this.rooms = rooms;
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
        public boolean valid() {
            return r >= 0 && c >= 0 && r < rooms.length && c < rooms[0].length;
        }
    }
}