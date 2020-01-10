package pp1004;

class Solution {
    public int longestOnes(int[] A, int K) {
        int max = 0;
        int length = 0;
        int count = 0;
        int i = 0;
        int j = -1;
        while (++j < A.length) {
            length++;
            if (A[j] == 0) {
                count++;
            }
            while (count > K) {
                if (A[i++] == 0) {
                    count--;
                }
                length--;
            }
            max = Math.max(max, length);
        }
        return max;
    }
}
