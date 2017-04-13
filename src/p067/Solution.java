package p067;
public class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        int carry = 0;
        int k = 0;
        int n = Math.max(a.length(), b.length());
        for (int i = 0; i < n; i++) {
            k = get(a, i) + get(b, i) + carry;
            carry = k / 2;
            result = (k % 2) + result;
        }
        if (carry != 0) result = 1 + result;
        return result;
    }
    
    private int get(String str, int index) {
        if (str.length() <= index) return 0;
        else return str.charAt(str.length() - index - 1) - '0';
    }
}