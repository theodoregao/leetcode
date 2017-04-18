package p552;
public class Solution {
    long M = 1000000007;
    public int checkRecord(int n) {
        long a0l0 = 1;
        long a0l1 = 0, a0l2 = 0, a1l0 = 0, a1l1 = 0, a1l2 = 0;
        for (int i = 0; i < n; i++) {
            long na0l0 = (a0l0 + a0l1 + a0l2) % M;
            long na0l1 = a0l0 % M;
            long na0l2 = a0l1 % M;
            long na1l0 = (a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % M;
            long na1l1 = a1l0 % M;
            long na1l2 = a1l1 % M;
            a0l0 = na0l0;
            a0l1 = na0l1;
            a0l2 = na0l2;
            a1l0 = na1l0;
            a1l1 = na1l1;
            a1l2 = na1l2;
        }
        return (int) ((a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % M);
    }
}