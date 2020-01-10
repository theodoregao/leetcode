package pp1198;

class Solution {
    
    public static int search(int[] a, int key) {
        return search(a, key, 0, a.length - 1);
    }
    
    public static int search(int[] a, int key, int lo, int hi) {
        int mid = (lo + hi) >>> 1;
        
        while (lo <= hi) {
            if (key == a[mid]) return mid;
            else if (key < a[mid]) hi = mid - 1;
            else /*if (key > a[mid])*/ lo = mid + 1;
            mid = (lo + hi) >>> 1;
        }
        return -1;
    }
    
    public int smallestCommonElement(int[][] mat) {
        if (mat.length == 1) {
            return mat[0][0];
        }
        for (int v: mat[0]) {
            boolean failed = false;
            for (int i = 1; !failed && i < mat.length; i++) {
                if (search(mat[i], v) == -1) {
                    failed = true;
                }
            }
            if (!failed) {
                return v;
            }
        }
        return -1;
    }
}
