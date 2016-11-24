package p424;
public class Solution {
	
    public int characterReplacement(String s, int k) {
    	char[] chars = s.toCharArray();
        int max = 0;
        int n = s.length();
        int i, j, count, replace;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
        	count = 0;
        	replace = k;
        	for (i = 0, j = 0; j < n; j++) {
        		if (chars[j] == ch) count++;
        		else {
        			replace--;
        			count++;
        			while (replace < 0) {
        				count--;
        				if (chars[i++] != ch) replace++;
        			}
        		}
        		max = Math.max(max, count);
        	}
        }
        return max;
    }
    
}