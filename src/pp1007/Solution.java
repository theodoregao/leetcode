package pp1007;

class Solution {
    
    private int count(int target, int[] A, int B[]) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != target) {
                if (B[i] == target) {
                    count++;
                }
                else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return count;
    }
    
    public int minDominoRotations(int[] A, int[] B) {
        int a = Math.min(count(A[0], A, B), count(A[0], B, A));
        int b = Math.min(count(B[0], A, B), count(B[0], B, A));
        int count = Math.min(a, b);
        return count < Integer.MAX_VALUE ? count : -1;
    }
}
