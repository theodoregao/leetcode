package p043;
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 1 && num1.charAt(0) == '0' || num2.length() == 1 && num2.charAt(0) == '0') return "0";
        return toString(multiple(toInts(num1), toInts(num2)));
    }
    
    private int[] multiple(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < right.length; j++)
                result[i + j] += left[i] * right[j];
        }
        for (int i = 0; i < result.length - 1; i++) {
            result[i + 1] += result[i] / 10000;
            result[i] %= 10000;
        }
        return result;
    }

    private int[] toInts(String num) {
        int[] ints = new int[(num.length() + 3) / 4];
        for (int lo = num.length() - 4, hi = num.length(), i = 0; i < ints.length; i++, lo -= 4, hi -= 4)
            ints[i] = Integer.parseInt(num.substring(Math.max(0, lo), hi));
        return ints;
    }
    
    private String toString(int[] ints) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ints.length; i++) sb.insert(0, String.format("%04d", ints[i]));
        int pos = 0;
        while (sb.charAt(pos) == '0') pos++;
        return sb.substring(pos).toString();
    }
    
    private static void print(int[] ints) {
        for (int i = 0; i < ints.length; i++) System.out.println(ints[i]);
    }
    
    public static void main(String[] args) {
        Solution.print(new Solution().toInts("123456789"));
    }
}