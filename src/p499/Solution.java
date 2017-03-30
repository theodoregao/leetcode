package p499;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int[][] DIR = new int[][] {{1,0},{0,-1},{0,1},{-1,0}};
    private char[] DIR_NAME = new char[] {'d','l','r','u'};
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (maze.length == 0 || maze[0].length == 0) return "impossible";
        int m = maze.length;
        int n = maze[0].length;
        int sr = ball[0];
        int sc = ball[1];
        int dr = hole[0];
        int dc = hole[1];
        
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

            if (l.r == dr && l.c == dc) {
                String directions = "";
                Location fl = l;
                while (fl.distance != 0) {
//                    System.out.println(fl);
                    if (directions.isEmpty() || directions.charAt(0) != DIR_NAME[fl.dir])
                        directions = DIR_NAME[fl.dir] + directions;
                    fl = from[fl.r][fl.c][fl.dir];
                }
                return directions;
            }
            
            Location next = new Location(maze, l.r + DIR[l.dir][0], l.c + DIR[l.dir][1], l.dir, l.distance + 1);
            if (next.valid()){
                if (from[next.r][next.c][next.dir] == null) {
                    from[next.r][next.c][next.dir] = l;
                    queue.add(next);
                }
            }
            else for (int d = 0; d < DIR.length; d++) {
                Location neighbor = new Location(maze, l.r + DIR[d][0], l.c + DIR[d][1], d, l.distance + 1);
                if (neighbor.valid() && from[neighbor.r][neighbor.c][neighbor.dir] == null) {
                    from[neighbor.r][neighbor.c][neighbor.dir] = l;
                    queue.add(neighbor);
                }
            }
        }
        return "impossible";
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