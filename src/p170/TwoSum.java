package p170;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    
    private Map<Integer, Integer> map = new HashMap<>();

    /** Initialize your data structure here. */
    public TwoSum() {
        
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.containsKey(number) ? 2 : 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int key: map.keySet()) {
            if (key == value - key && map.get(key) > 1 || key != value - key && map.containsKey(value - key)) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(0);
        System.out.println(twoSum.find(0));
        twoSum.add(0);
        System.out.println(twoSum.find(0));
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */