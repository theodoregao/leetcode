package leetcode.facebook.p286;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static Position[] DIRS = new Position[] {
        new Position(-1, 0), new Position(1, 0), 
        new Position(0, -1), new Position(0, 1)};
    
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length <= 0 || rooms[0].length <= 0) return;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++)
                if (rooms[i][j] == 0) fill(rooms, new Position(i, j));
        }
    }
    
    private void fill(int[][] rooms, Position position) {
        Queue<Position> queue = new LinkedList<Position>();
        queue.add(position);
        
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int distance = rooms[pos.i][pos.j];
            for (int i = 0; i < DIRS.length; i++) {
                if (isVisitable(rooms, pos.i + DIRS[i].i, pos.j + DIRS[i].j, distance + 1)) {
                    Position newPosition = new Position(pos.i + DIRS[i].i, pos.j + DIRS[i].j);
                    rooms[newPosition.i][newPosition.j] = distance + 1;
                    queue.offer(newPosition);
                }
            }
        }
    }
    
    private boolean isVisitable(int[][] rooms, int i, int j, int distance) {
        return i >= 0 && i < rooms.length && j >= 0 && j < rooms[0].length
                && rooms[i][j] > 0 && distance < rooms[i][j];
    }
    
    static class Position {
        int i, j;
        Position(int i, int j) { this.i = i; this.j = j; }
    }
    
    public static void main(String[] args) {
        int[][] rooms = new int[][] {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        
        new Solution().wallsAndGates(rooms);
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }
}