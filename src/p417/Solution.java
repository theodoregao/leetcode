package p417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    
    private static int ROW;
    private static int COL;
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        ROW = matrix.length;
        if (ROW == 0) return new ArrayList<>();
        COL = matrix[0].length;
        
        Set<Position> pacific = new HashSet<>();
        Set<Position> atlantic = new HashSet<>();
        
        boolean[][] visited = new boolean[ROW][COL];
        
        Queue<Position> queue = new LinkedList<Solution.Position>();
        for (int i = 0; i < matrix.length; i++) queue.add(new Position(i, 0));
        for (int i = 0; i < matrix[0].length; i++) queue.add(new Position(0, i));
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            pacific.add(pos);
            for (Position neighbor: pos.filterNeighbors(matrix, visited)) {
                queue.offer(neighbor);
                visited[pos.i][pos.j] = true;
            }
        }
        
        for (int i = 0; i < ROW; i++) for (int j = 0; j < COL; j++) visited[i][j] = false;
        for (int i = 0; i < matrix.length; i++) queue.add(new Position(i, COL - 1));
        for (int i = 0; i < matrix[0].length; i++) queue.add(new Position(ROW - 1, i));
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            atlantic.add(pos);
            for (Position neighbor: pos.filterNeighbors(matrix, visited)) {
                queue.offer(neighbor);
                visited[pos.i][pos.j] = true;
            }
        }

        int k = 0;
        Position[] posPacific = new Position[pacific.size()];
        for (Position pos: pacific) posPacific[k++] = pos;
        k = 0;
        Position[] posAtlantic = new Position[atlantic.size()];
        for (Position pos: atlantic) posAtlantic[k++] = pos;
        Arrays.sort(posAtlantic);
        
        List<int[]> intersection = new ArrayList<>();
        for (Position pos: posPacific)
            if (Arrays.binarySearch(posAtlantic, pos) >= 0)
                intersection.add(new int[] {pos.i, pos.j});
        
        return intersection;
    }
    
    private static class Position implements Comparable<Position> {
        
        private static int[] X = new int[] {-1, 1, 0, 0};
        private static int[] Y = new int[] {0, 0, -1, 1};
        
        int i;
        int j;
        
        Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
        
        Position[] filterNeighbors(int[][] matrix, boolean[][] visited) {
            List<Position> list = new ArrayList<>();
            for (int k = 0; k < 4; k++) {
                int x = X[k] + j;
                int y = Y[k] + i;
                if (x >= 0 && x < COL && y >= 0 && y < ROW && !visited[y][x] && matrix[i][j] <= matrix[y][x]) list.add(new Position(y, x));
            }
            Position[] positions = new Position[list.size()];
            int k = 0;
            for (Position pos: list) positions[k++] = pos;
            return positions;
        }
        
        @Override
        public boolean equals(Object obj) {
            Position other = (Position) obj;
            return i == other.i && j == other.j;
        }
        
        @Override
        public int hashCode() {
            return toString().hashCode();
        }
        
        @Override
        public String toString() {
            return i + ":" + j;
        }

        @Override
        public int compareTo(Position o) {
            return toString().compareTo(o.toString());
        }
        
    }
    
    public static void main(String[] args) {
//        new Solution().pacificAtlantic(new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
        new Solution().pacificAtlantic(new int[][] {{3,3,3,3,3,3},{3,0,3,3,0,3},{3,3,3,3,3,3}});
    }
}