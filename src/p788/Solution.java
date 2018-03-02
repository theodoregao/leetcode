package p788;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private static Set<Integer> setGood;
    private static Set<Integer> setBad;
    
    static {
        setGood = new HashSet<>();
        setGood.add(2);
        setGood.add(5);
        setGood.add(6);
        setGood.add(9);
        
        setBad = new HashSet<>();
        setBad.add(3);
        setBad.add(4);
        setBad.add(7);
    }
    
    public int rotatedDigits(int N) {
        int n = 0;
        while (N > 0) {
            if (isGood(N)) n++;
            N--;
        }
        return n;
    }
    
    private boolean isGood(int n) {
        boolean good = false;
        while (n != 0) {
            if (setGood.contains(n % 10)) {
                good = true;
            }
            else if (setBad.contains(n % 10)) {
                return false;
            }
            n /= 10;
        }
        return good;
    }
}
