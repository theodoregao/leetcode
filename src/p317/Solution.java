package p317;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    
    public int shortestDistance(int[][] grid) {
//        print(grid);
        int[][][][] grids = new int[grid.length][grid[0].length][][];
        List<Location> buildings = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) buildings.add(new Location(i, j));
                else if (grid[i][j] == 0) {
                    grids[i][j] = init(grid, i, j);
                    bfs(grid, grids[i][j], i, j);
                }
            }
        }
        
        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
//                    print(grids[i][j]);
                    int thisCost = 0;
                    for (Location location: buildings) {
                        int dis = grids[i][j][location.i][location.j];
                        if (dis < 0 || dis == Integer.MAX_VALUE) {
                            thisCost = Integer.MAX_VALUE;
                            break;
                        }
                        else thisCost += dis;
                    }
                    cost = Math.min(cost, thisCost);
                }
            }
        }
        
        return cost == Integer.MAX_VALUE ? -1 : cost;
    }
    
    private void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) System.out.print(grid[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
    
    private int[][] init(int[][] grid, int r, int c) {
        int[][] newGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 0 || grid[i][j] == 1) newGrid[i][j] = Integer.MAX_VALUE;
                else if (grid[i][j] == 2) newGrid[i][j] = -2;
        newGrid[r][c] = 0;
        return newGrid;
    }
    
    private static class Location {
        int i; int j;
        public Location(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    private static int[][] DIR = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private void bfs(int[][] map, int[][] grid, int r, int c) {
        Queue<Location> queue = new LinkedList<Solution.Location>();
        queue.offer(new Location(r, c));
        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int k = 0; k < DIR.length; k++) {
                int i = location.i + DIR[k][0];
                int j = location.j + DIR[k][1];
                if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
                    if (grid[i][j] > grid[location.i][location.j] + 1) {
                        grid[i][j] = grid[location.i][location.j] + 1;
                        if (map[i][j] == 0) queue.offer(new Location(i, j));
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().shortestDistance(new int[][] {
                {1,0,2,0,1}, {0,0,0,0,0}, {0,0,1,0,0}
        }));
        System.out.println(new Solution().shortestDistance(new int[][] {
                {1,2,0}
        }));
        System.out.println(new Solution().shortestDistance(new int[][] {
                {0,2,1}, {1,0,2}, {0,1,0}
        }));
        System.out.println(new Solution().shortestDistance(new int[][] {
                {1,1}, {0,1}
        }));
    }
    
}