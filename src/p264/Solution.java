package p264;
public class Solution {
    public int nthUglyNumber(int n) {
        int[] uglys = new int[n];
        uglys[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++) {
            int v2 = uglys[index2] * 2;
            int v3 = uglys[index3] * 3;
            int v5 = uglys[index5] * 5;
            uglys[i] = Math.min(v2, Math.min(v3, v5));
            if (uglys[i] == v2) index2++;
            if (uglys[i] == v3) index3++;
            if (uglys[i] == v5) index5++;
        }
        return uglys[n - 1];
    }
    public int TLEnthUglyNumber(int n) {
        int k = 1;
        for (int i = 0; i < n; i++, k++)
            while (!isUgly(k)) k++;
        return k - 1;
    }
    
    private boolean isUgly(int n) {
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(1690));
    }
}