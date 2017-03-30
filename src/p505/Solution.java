package p505;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int[][] DIR = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) return -1;
        int m = maze.length;
        int n = maze[0].length;
        int sr = start[0];
        int sc = start[1];
        int dr = destination[0];
        int dc = destination[1];
        
        Location[][][] from = new Location[m][n][DIR.length];
        Queue<Location> queue = new LinkedList<>();
        for (int d = 0; d < DIR.length; d++) {
            Location s = new Location(maze, sr, sc, d, 0);
            if (s.valid()) {
                queue.add(s);
                from[sr][sc][d] = new Location(maze, -1, -1, 0, -1);
            }
            
        }
        
        while (!queue.isEmpty()) {
            Location l = queue.poll();
            Location next = new Location(maze, l.r + DIR[l.dir][0], l.c + DIR[l.dir][1], l.dir, l.distance + 1);
            if (next.valid()){
                if (from[next.r][next.c][next.dir] == null) {
                    from[next.r][next.c][next.dir] = l;
                    queue.add(next);
                }
            }
            else {
                if (l.r == dr && l.c == dc) {
//                    Location fl = from[l.r][l.c][l.dir];
//                    while (fl.distance != -1) {
//                        System.out.println(fl);
//                        fl = from[fl.r][fl.c][fl.dir];
//                    }
                    return l.distance;
                }
                else for (int d = 0; d < DIR.length; d++) {
                    Location neighbor = new Location(maze, l.r + DIR[d][0], l.c + DIR[d][1], d, l.distance + 1);
                    if (neighbor.valid() && from[neighbor.r][neighbor.c][neighbor.dir] == null) {
                        from[neighbor.r][neighbor.c][neighbor.dir] = l;
                        queue.add(neighbor);
                    }
                }
            }
        }
        return -1;
    }
    
    private static class Location {
        int[][] maze;
        int r;
        int c;
        int dir;
        int distance;
        public Location(int[][] maze, int r, int c, int dir, int distance) {
            this.maze = maze;
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.distance = distance;
        }
        public boolean valid() {
            return r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && maze[r][c] != 1;
        }
        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append(Location.class.getSimpleName());
            sb.append("{").append(r).append(",").append(c).append(":").append(dir).append("}");
            return sb.toString();
        }
    }
}