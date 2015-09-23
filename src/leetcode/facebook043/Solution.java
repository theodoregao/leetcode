package leetcode.facebook043;
public class Solution {
    public String multiply(String num1, String num2) {
        int sz = num1.length() + num2.length() - 1;
        int[] result = new int[sz];
        
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                result[sz - i - j - 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        
        for (int i = 0; i < result.length - 1; i++) {
            result[i + 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }
        
        int index = result.length - 1;
        while (index >= 0 && result[index] == 0) index--;
        
        if (index < 0) return "0";
        else {
            StringBuffer sb = new StringBuffer();
            for (int i = index; i >= 0; i--) sb.append(result[i]);
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("9999", "9999"));
        System.out.println(new Solution().multiply("0", "000"));
        System.out.println(new Solution().multiply("1", "1"));
    }
}