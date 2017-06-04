package p593;
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Vector v12 = new Vector(p1, p2);
        Vector v13 = new Vector(p1, p3);
        Vector v14 = new Vector(p1, p4);
        Vector v24 = new Vector(p2, p4);
        Vector v23 = new Vector(p2, p3);
        Vector v34 = new Vector(p3, p4);
        if (equals(p1, p2) || equals(p1, p3) || equals(p1, p4) || equals(p2, p3) || equals(p2, p3) || equals(p3, p4)) return false;
        if (v12.perpendicular(v13) && v14.perpendicular(v23) && v12.plus(v13).equals(v14)) return true;
        if (v12.perpendicular(v14) && v13.perpendicular(v24) && v12.plus(v14).equals(v13)) return true;
        if (v14.perpendicular(v13) && v12.perpendicular(v34) && v14.plus(v13).equals(v12)) return true;
        return false;
    }
    
    private boolean equals(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }
    
    private class Vector {
        int x, y;
        Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Vector(int[] a, int[] b) {
            x = b[0] - a[0];
            y = b[1] - a[1];
        }
        Vector minus(Vector v) {
            return new Vector(x - v.x, y - v.y);
        }
        Vector plus(Vector v) {
            return new Vector(x + v.x, y + v.y);
        }
        boolean equals(Vector v) {
            return x == v.x && y == v.y;
        }
        boolean perpendicular(Vector v) {
            return x * v.x + y * v.y == 0;
        }
    }
}