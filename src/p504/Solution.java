package p504;
public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean flag = num < 0;
        num = Math.abs(num);
        String string = "";
        while (num > 0) {
            string = (num % 7) + string;
            num /= 7;
        }
        return flag ? "-" + string : string;
    }
    
    public static void main(String[] args) {
        for (int i = -100; i < 100; i++) System.out.println(new Solution().convertToBase7(i));
    }
}