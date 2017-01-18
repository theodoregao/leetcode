package p247;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return recursive(n, n);
    }
    
    private List<String> recursive(int m, int n) {
    	if (m == 0) return new ArrayList<>(Arrays.asList(""));
    	if (m == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

    	List<String> list = recursive(m - 2, n);
    	List<String> rst = new ArrayList<>();
    	for (String s: list) {
    		if (m != n) rst.add("0" + s + "0");
    		rst.add("1" + s + "1");
    		rst.add("6" + s + "9");
    		rst.add("8" + s + "8");
    		rst.add("9" + s + "6");
    	}
    	
    	return rst;
    }
}