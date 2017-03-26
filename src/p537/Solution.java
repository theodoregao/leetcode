package p537;
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        int index1 = a.indexOf("+", 1);
        int index2 = b.indexOf("+", 1);
        int[] num1 = new int[] {Integer.parseInt(a.substring(0, index1)),
                Integer.parseInt(a.substring(index1 + 1, a.length() - 1))};
        int[] num2 = new int[] {Integer.parseInt(b.substring(0, index2)),
                Integer.parseInt(b.substring(index2 + 1, b.length() - 1))};
        int imag = num1[0] * num2[1] + num1[1] * num2[0];
        return (num1[0] * num2[0] - num1[1] * num2[1]) + "+" + imag + "i";
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(new Solution().complexNumberMultiply("1+-1i", "1+-1i"));
    }
}