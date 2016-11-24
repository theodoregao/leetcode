package p415;
public class Solution {
    public String addStrings(String num1, String num2) {
        int n = Math.max(num1.length(), num2.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int v;
        for (int i = 0; i < n; i++) {
        	v = getValue(num1, i) + getValue(num2, i) + carry;
        	carry = v / 10;
        	sb.insert(0, "" + (v % 10));
        }
        if (carry != 0) sb.insert(0, "" + carry);
        return sb.toString();
    }
    
    private int getValue(String num, int pos) {
    	if (pos >= num.length()) return 0;
    	else return num.charAt(num.length() - pos - 1) - '0';
    }
}