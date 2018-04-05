package p765;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minSwapsCouples(int[] row) {
        List<Integer[]> list = new ArrayList<>();
        
        for (int i = 0; i < row.length / 2; i++) {
            int a = row[i * 2] / 2;
            int b = row[i * 2 + 1] / 2;
            if (a != b) list.add(new Integer[] {a, b});
        }
        
        int n = 0;
        while (list.size() > 0) {
            Integer[] a = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i)[0] == a[0] || list.get(i)[1] == a[0]) {
                    a[0] = list.get(i)[0] != a[0] ? list.get(i)[0] : list.get(i)[1];
                    list.remove(i);
                    if (a[0] == a[1]) list.remove(0);
                    n++;
                    break;
                }
            }
        }
        return n;
    }
}