package p405;
public class Solution {
    public String toHex(int num) {
    	if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
        	sb.insert(0, toHexInternal(num & 0x0F));
        	num >>>= 4;
        }
        if (num < 0) sb.insert(0, '-');
        return sb.toString();
    }
    
    private char toHexInternal(int num) {
    	if (num < 10) return (char) ('0' + num);
    	else return (char) ('a' + (num - 10));
    }
}